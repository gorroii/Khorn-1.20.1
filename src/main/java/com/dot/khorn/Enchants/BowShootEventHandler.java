package com.dot.khorn.Enchants;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber
public class BowShootEventHandler {

        @SubscribeEvent
        public static void onArrowLoose(ArrowLooseEvent event) {
            LivingEntity entity = event.getEntity();
            if (entity instanceof Player player) {
                ItemStack bow = event.getBow();
                if (bow.getItem() instanceof CrossbowItem || bow.getItem() instanceof BowItem) {
                    Level level = player.level();
                    Random random = new Random();
                    int megashot = bow.getEnchantmentLevel((Enchantment) ModEnchantments.MEGA_SHOT.get());
                    if (megashot > 0) {
                        event.setCanceled(true); // Отменяем стандартный выстрел
                        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F);

                        boolean isFlaming = bow.getEnchantmentLevel(Enchantments.FLAMING_ARROWS) > 0;
                        int arrowCount = 2 + megashot; // Количество стрел
                        float charge = (float) event.getCharge() / 20.0F;
                        charge = Math.min(charge, 1.0F); // Ограничение до 1.0

                        float spread = (5.0F + megashot * 0.5f) * (1.6F - charge);
                        float velocity = 3.0F * charge;

                        // Проверяем, есть ли стрелы в инвентаре (если не креатив)
                        if (!player.getAbilities().instabuild) {
                            ItemStack arrowStack = null;

                            for (ItemStack item : player.getInventory().items) {
                                if (item.getItem() instanceof net.minecraft.world.item.ArrowItem && item.getCount() > 0) {
                                    arrowStack = item;
                                    break;
                                }
                            }

                            if (arrowStack == null) return; // Если нет стрел, отменяем выстрел
                            arrowStack.shrink(1); // Удаляем только 1 стрелу
                        }

                        Vec3 lookVec = player.getLookAngle();
                        boolean firstArrow = true; // Флаг для первой стрелы

                        for (int i = 0; i < arrowCount; ++i) {
                            Arrow arrow = new Arrow(level, player);

                            double offsetX = (random.nextDouble() - 0.5) * spread * 0.1;
                            double offsetY = (random.nextDouble() - 0.5) * spread * 0.1;
                            double offsetZ = (random.nextDouble() - 0.5) * spread * 0.1;

                            Vec3 shootVec = lookVec.add(offsetX, offsetY, offsetZ).normalize();
                            arrow.shoot(shootVec.x, shootVec.y, shootVec.z, velocity, 1.0F);

                            if (isFlaming) {
                                arrow.setSecondsOnFire(100);
                            }


                            // Только первая стрела подбирается, остальные исчезают
                            if (firstArrow) {
                                arrow.pickup = AbstractArrow.Pickup.ALLOWED;
                                firstArrow = false;
                            } else {
                                arrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                            }

                            level.addFreshEntity(arrow);
                        }
                    }
                }
            }
        }
    }
