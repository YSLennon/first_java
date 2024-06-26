package day8;

public class Calculator implements Calc {

	@Override
	public int sum(int x, int y) {
		// TODO Auto-generated method stub
		return x+y;
	}

	@Override
	public int sub(int x, int y) {
		// TODO Auto-generated method stub
		return x-y;
	}

	@Override
	public int mul(int x, int y) {
		// TODO Auto-generated method stub
		return x*y;
	}

	@Override
	public double div(int x, int y) {
		// TODO Auto-generated method stub
		if(y ==0) {
			System.out.println("0으로 나눌 수 없어 0을 출력합니다.");
			return 0;
		}
		return (double)x/y;
	}

}
