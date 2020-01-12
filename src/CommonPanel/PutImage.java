package CommonPanel;

public class PutImage{
	
	private String src[];
	private int[] x;
	private int[] y;
	private int[] width;
	private int[] height;
	
	public PutImage(int[][] size, String general, String folder)
	{
		x = size[0];
		y = size[1];
		width = size[2];
		height = size[3];
		
		src = new String[size[0].length];
		
		for(int i=0; i<size[0].length; i++)
		{
			src[i] = folder + general +  + i + ".png";
		}
	}
	
	public int[] getX() {
		return x;
	}

	public int[] getY() {
		return y;
	}

	public int[] getWidth() {
		return width;
	}

	public int[] getHeight() {
		return height;
	}
	public String[] getSrc() {
		return src;
	}

}