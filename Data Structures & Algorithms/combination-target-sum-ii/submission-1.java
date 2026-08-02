class Solution {
    private void solve(
        int[] nums, int target, int index, List<Integer> temp, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            // Skip duplicates
            if (i > index && nums[i] == nums[i - 1])
                continue;

            if (nums[i] > target)
                break;

            temp.add(nums[i]);

            solve(nums, target - nums[i], i + 1, temp, result);

            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        solve(candidates, target, 0, temp, result);

        return result;
    }
}
















// 📍 LEVEL 0 — solve(target=3, index=0, temp=[])

//   i=0 → nums[0]=1
//   ├── pick → temp=[1]
//   └── CALL solve(target=2, index=1, temp=[1])
//       │
//       │  📍 LEVEL 1 — solve(target=2, index=1, temp=[1])
//       │
//       │  i=1 → nums[1]=1
//       │  ├── pick → temp=[1,1]
//       │  └── CALL solve(target=1, index=2, temp=[1,1])
//       │      │
//       │      │  📍 LEVEL 2 — solve(target=1, index=2, temp=[1,1])
//       │      │
//       │      │  i=2 → nums[2]=2
//       │      │  └── 2 > target(1) → BREAK ✂️ (loop khatam, kuch add nahi)
//       │      │
//       │      └── return (backtrack)
//       │
//       │  temp.remove() → temp=[1]     [wapas LEVEL 1 pe]
//       │
//       │  i=2 → nums[2]=2               ← same loop, i++ hua
//       │  ├── pick → temp=[1,2]
//       │  └── CALL solve(target=0, index=3, temp=[1,2])
//       │      │
//       │      │  📍 LEVEL 2 — solve(target=0, index=3, temp=[1,2])
//       │      │
//       │      │  target==0 → result.add([1,2])  ✅ FOUND
//       │      │
//       │      └── return
//       │
//       │  temp.remove() → temp=[1]
//       │  loop khatam (i=3 > length)
//       │
//       └── return (backtrack)

//   temp.remove() → temp=[]     [wapas LEVEL 0 pe]

//   i=1 → nums[1]=1
//   └── i(1) > index(0) && nums[1]==nums[0] → DUPLICATE
//       → continue ⏭️ (skip, koi call nahi lagi)

//   i=2 → nums[2]=2
//   ├── pick → temp=[2]
//   └── CALL solve(target=1, index=3, temp=[2])
//       │
//       │  📍 LEVEL 1 — solve(target=1, index=3, temp=[2])
//       │
//       │  for i=3 to 2 → loop chalega hi nahi (i >= length)
//       │
//       └── return (kuch add nahi, target=1 hi reh gaya ❌)

//   temp.remove() → temp=[]
//   loop khatam (i=3 > length)

// return













