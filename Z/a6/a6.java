import java.util.Scanner;


public class A6 {
	
	
	public static char lower[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	public static char upper[]={'Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M'};
	
	public static String doEncryption(String text)
	{
		char result[]=new char[text.length()];
		
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < 26; j++) {
				
				if(lower[j]==text.charAt(i))
				{
					result[i]=upper[j];
				}
			}
			System.out.println(text.charAt(i) + " " + result[i]);
		}
		
		return new String(result);
		
	}
	
	public static String doEncryption(String text, int shift )
	{
		if(shift<0)
		{
			return "Invalid input: ";
		}
		
		char result[]=new char[text.length()];
		
		for(int i=0;i<text.length();i++)
		{
			if(Character.isUpperCase(text.charAt(i)))
			{
				result[i]= (char)((((int)text.charAt(i)+shift-65)%26)+65);
			}
			
			if(Character.isLowerCase(text.charAt(i)))
			{
				result[i]=(char)(((int) text.charAt(i) + shift - 97)%26 +97);
				
			}
		}
		
		
		return new String(result);
	}

	public static void main(String[] args)
	{
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter password : ");
		String text = scanner.next();
		System.out.println("Enter Choice: \n1.Caesar Cipher \n2.Monolithic Cipher\n");
		int choice=scanner.nextInt();
		switch(choice)
		{
			case 1:	
						System.out.println("Enter shift:");
						int s =scanner.nextInt() ;
						System.out.println("Caesar Cipher : "+doEncryption(text,s));
						break;
			case 2:	
						System.out.println("Monolythic Cipher : "+doEncryption(text));
						break;

		}
		scanner.close();
		
		
		
		
	}
}

