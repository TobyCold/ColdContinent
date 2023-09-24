package love.iloveworld.continent.capability;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerPropertiesProvider implements ICapabilityProvider, INBTSerializable {

    private PlayerProperties playerProperties;
    public static float moisture;
    public static float spirit;
    public static float immunity;

    public static final Capability<PlayerProperties> PLAYER_PROPERTIES_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {
    });

    private final LazyOptional<PlayerProperties> lazyOptional = LazyOptional.of(() -> this.playerProperties);

    public PlayerPropertiesProvider() {
        this.playerProperties = new PlayerProperties();
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return getCapability(cap);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        if (cap == PLAYER_PROPERTIES_CAPABILITY) {
            return lazyOptional.cast();
        } else {
            return lazyOptional.empty();
        }
    }

    //序列化NBT
    @Override
    public Tag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        playerProperties.saveData(tag);
        return tag;
    }
    @Override
    public void deserializeNBT(Tag nbt) {
        playerProperties.loadData((CompoundTag) nbt);
    }
}
