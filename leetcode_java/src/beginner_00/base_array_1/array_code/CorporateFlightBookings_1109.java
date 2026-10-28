package beginner_00.base_array_1.array_code;

/**1109.航班预订统计
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
 *
 * 示例 1：
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 *
 * 示例 2：
 * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
 * 输出：[10,25]
 * 解释：
 * 航班编号        1   2
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       15
 * 总座位数：      10  25
 * 因此，answer = [10,25]
 */
public class CorporateFlightBookings_1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 使用差分数组+前缀和
        // 先统计每个航班预定计数变化
        int[] diff = new int[n+1];  // 长度+1是为了防止区间航班结束后,后续的计数统计不越界
        // diff每条索引对应的值表示的是当前航班对应上一个航班预定座位的增减
        for (int[] booking : bookings) {
            diff[booking[0] -1] += booking[2];   // 每个预定列表中第一个为预定航班起始,对应在diff中索引需要-1
            diff[booking[1]] -= booking[2];      // 结束航班后的航班不在当前预定列表,所以不添加预定座位
        }
        int[] answer = new int[n];  // 全部航班的预定座位数
        int current_seats = 0;      // 当前航班累计的座位数
        for (int i = 0; i < n; i++) {
            answer[i] = current_seats + diff[i];    // 第i个航班座位数 = 上一趟航班座位数+当前航班的座位数增减量
            current_seats = answer[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        CorporateFlightBookings_1109 obj = new CorporateFlightBookings_1109();
        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        int[] ans = obj.corpFlightBookings(bookings, 5);
        System.out.println(java.util.Arrays.toString(ans)); // 期望 [10, 55, 45, 25, 25]
    }

}
