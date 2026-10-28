package beginner_00.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**56.合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 示例 3：
 * 输入：intervals = [[4,7],[1,4]]
 * 输出：[[1,7]]
 * 解释：区间 [1,4] 和 [4,7] 可被视为重叠区间。
 */
public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        // 先排序,按照区间中的第一个数排序，直接在原数组上操作
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // 再合并
        // 按照排序后的数组来看,先指定一个当前数组,然后比较当前数组的最后一个元素是否大于等于下一个数组的第一个元素,如果满足说明重叠
        // 然后比较两个数组的最后一个元素,谁大取谁,就合并了,然后继续重复比较
        int[] current_interval = intervals[0];    // 定义一个初始数组和排序后的进行比较,如果重叠进行合并,没找到重叠的就添加进res,然后重新赋值
        List<int[]> res = new ArrayList<>(); // 定义数组接收合并后的数组
        for (int[] interval : intervals) {
            if (current_interval[1] >= interval[0]) {
                // 重叠,然后判断两个数组谁大
                current_interval[1] = Math.max(current_interval[1], interval[1]);
            } else {
                // 不重叠,先把当前之前的数组添加进res,然后将当前的数组记录下来
                res.add(current_interval);
                current_interval = interval;
            }
        }
        res.add(current_interval);
        return res.toArray(new int[0][]);
    }
}
