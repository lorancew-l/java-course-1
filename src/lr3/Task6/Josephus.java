package src.lr3.Task6;

import java.util.AbstractList;

public class Josephus {
  private AbstractList<Integer> list;
  private int k;

  public Josephus(int N, int k, AbstractList<Integer> list) {
    this.list = list;
    this.k = k;

    for (int i = 1; i <= N; i++) {
      list.add(i);
    }
  }

  public int josephus() {
    int index = 0;

    while (this.list.size() > 1) {
      index = (index + this.k - 1) % this.list.size();
      this.list.remove(index);
    }
    return this.list.get(0);
  }

}