 class TimeMap {
    Map<String, Map<Integer, List<String>>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        keyStore.putIfAbsent(key, new HashMap<>());
        if (!keyStore.get(key).containsKey(timestamp)) {
            keyStore.get(key).put(timestamp, new ArrayList<>());
        }
        keyStore.get(key).get(timestamp).add(value);
    }

     public String get(String key, int timestamp) {
        if (!keyStore.containsKey(key)) {
            return "";
        }
        if (keyStore.get(key).containsKey(timestamp)) {
            return keyStore.get(key).get(timestamp).getFirst();
        }
        int seen = 0;
        for (int i = timestamp; i >= 0; i--) {
            if (keyStore.get(key).containsKey(i)) {
                seen = i;
                break;
            }
        }
        if (seen == 0) return "";
        return keyStore.get(key).get(seen).getFirst();
    }
}
