package com.tuhin.examples;

import java.util.List;

public class StreamAnyMatchTest {
    public static void main(String[] args) {
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4", "Store 5", "Store 6");
        List<String> asapioEnabledStores = List.of("Store 3", "Store 4");
        String storeSelected = "Store 3";
        final boolean includeRecord = stores.stream().filter(e -> isASAPIOEnabledStore(e, asapioEnabledStores)).anyMatch(includedNetworkLocation -> includedNetworkLocation.equals(storeSelected));
        System.out.println(includeRecord);
        System.out.println("Optimized "+ (stores.contains(storeSelected) && asapioEnabledStores.contains(storeSelected)));
    }

    private static boolean isASAPIOEnabledStore(String networkLocation, List<String> asapioEnabledStores) {
        System.out.println("networkLocation::" + networkLocation);
        return asapioEnabledStores.contains(networkLocation);
    }
}
