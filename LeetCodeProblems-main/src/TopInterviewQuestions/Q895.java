class FreqStack {

    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int max;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        max = 0;
    }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        if (f > max) {
            max = f;
        }
        group.computeIfAbsent(f, x -> new Stack<>()).push(val);
    }

    public int pop() {
        int val = group.get(max).pop();
        freq.put(val, freq.get(val) - 1);
        if(group.get(max).isEmpty()){
            max--;
        }
        return val;
    }
}
