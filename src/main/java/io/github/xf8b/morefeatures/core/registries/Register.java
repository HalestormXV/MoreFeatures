package io.github.xf8b.morefeatures.core.registries;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Register<T> {
    private final Map<T, Identifier> things;
    private final Registry<T> registry;
    private final String modid;

    public Register(Registry<T> registry, String modid) {
        things = new HashMap<>();
        this.registry = registry;
        this.modid = modid;
    }

    public <E extends T> E register(String name, E e) {
        if (things.containsKey(e)) {
            throw new IllegalArgumentException(e + "has already been registered!");
        }
        things.put(e, new Identifier(modid, name));
        return e;
    }

    public Set<T> getEntries() {
        return things.keySet();
    }

    public void registerAll() {
        things.forEach((t, identifier) -> Registry.register(registry, identifier, t));
    }
}
