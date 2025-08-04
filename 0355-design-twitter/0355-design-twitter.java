class Twitter {

    private Deque<Post> posts;
    private boolean[][] followMaps;
    //private Map<Integer, Set<Integer>> followMaps;

    public Twitter() {

        this.posts = new ArrayDeque<>();
        //this.followMaps = new HashMap<>();
        this.followMaps = new boolean[501][501];
    }

    public void postTweet(int userId, int tweetId) {

        this.posts.addFirst(new Post(userId, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        for (Post p : this.posts) {
            if (result.size() >= 10) {
                break;
            }

            //if (p.getUserId() == userId || followMaps.getOrDefault(userId, Set.of()).contains(p.getUserId())) {
            if (p.getUserId() == userId || followMaps[userId][p.getUserId()]) {

                result.add(p.getTweetId());
            }
        }
        
        return result;
    }

    // public void follow(int followerId, int followeeId) {

    //     Set<Integer> followeeSet = followMaps.getOrDefault(followerId, new HashSet<>());
    //     followeeSet.add(followeeId);
    //     followMaps.put(followerId, followeeSet);
    // }

    // public void unfollow(int followerId, int followeeId) {

    //     Set<Integer> followeeSet = followMaps.getOrDefault(followerId, new HashSet<>());
    //     followeeSet.remove(followeeId);
    //     followMaps.put(followerId, followeeSet);
    // }
    public void follow(int followerId, int followeeId) {

        this.followMaps[followerId][followeeId] = true;
    }

    public void unfollow(int followerId, int followeeId) {

        this.followMaps[followerId][followeeId] = false;
    }

    public static class Post {

        private int userId;
        private int tweetId;

        public Post(int userId, int tweetId) {

            this.userId = userId;
            this.tweetId = tweetId;
        }

        public int getUserId() {

            return this.userId;
        }

        public int getTweetId() {

            return this.tweetId;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */