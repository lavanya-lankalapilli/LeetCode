public class Q605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        boolean emptyLeft = false, emptyRight = false;
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0){
                emptyLeft = (i == 0) || (flowerbed[i - 1] == 0);
                emptyRight = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
                if (emptyLeft && emptyRight) {
                    flowerbed[i] = 1;
                    count++;
                    if(count>=n){
                        return true;
                    }
                }   
            }
        }
        return count >= n;
    }
}
