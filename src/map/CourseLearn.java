package src.map;

import java.util.*;

public class CourseLearn {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 定义入度数组，下标即为课程，记录课程的入度
        int[] inDegree = new int[numCourses];
        // 定义依赖关系表
        Map<Integer,List<Integer>> map = new HashMap<>();
        // 初始化入度数组
        for(int i=0;i< prerequisites.length;i++){
            // 每一个位于第1列的课程，都需要先修其他课程，因此入度++
            inDegree[prerequisites[i][0]]++;
            // 初始化选择第二列的课程后其可以减少其他课程入度的课程列表
            map.putIfAbsent(prerequisites[i][1],new ArrayList<>());
            // 添加当前元素
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        // 将所有的入度为 0 的课程添加到队列中
        Deque<Integer> que = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0){
                que.offer(i);
            }
        }
        // 依次选择某入度为 0 的课程之后，减少依赖它的课程的入度
        while (!que.isEmpty()){
            int course = que.poll();
            numCourses--;
            for(int next : map.getOrDefault(course,new ArrayList<>())){
                if (--inDegree[next] == 0){
                    que.offer(next);
                }
            }
        }
        return numCourses == 0;
    }
}
