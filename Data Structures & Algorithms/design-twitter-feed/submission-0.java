class Twitter {

    private int timestamp;                              // global time counter
    private Map<Integer, List<int[]>> tweetMap;        // userId -> [ [time, tweetId], ...]
    private Map<Integer, Set<Integer>> followMap;     // userId -> Set of followeeIds

    public Twitter() {
        timestamp = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    // ---------- postTweet ----------
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{timestamp++, tweetId});
        // timestamp++ → pehle current value use hogi, phir increment hogi
    }

    // ---------- getNewsFeed ----------
    public List<Integer> getNewsFeed(int userId) {

        // Max-Heap: sabse zyada (naya) timestamp wala tweet pehle
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Step 1: khud ke followees ka set nikaalo (khud ko bhi included karna hai)
        Set<Integer> followees = followMap.getOrDefault(userId, new HashSet<>());
        followees.add(userId);  // apne tweets bhi feed mein chahiye

        // Step 2: har followee ke saare tweets heap mein daal do
        for (int followeeId : followees) {
            List<int[]> tweets = tweetMap.get(followeeId);
            if (tweets != null) {
                for (int[] tweet : tweets) {
                    maxHeap.offer(tweet);
                }
            }
        }

        // Step 3: heap se top 10 (sabse recent) tweets nikaalo
        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            result.add(maxHeap.poll()[1]);  // tweetId nikaalo
            count++;
        }

        return result;
    }

    // ---------- follow ----------
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    // ---------- unfollow ----------
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
        // Note: khud ko khud se unfollow nahi kar sakte (edge case handle karna optional)
    }
}