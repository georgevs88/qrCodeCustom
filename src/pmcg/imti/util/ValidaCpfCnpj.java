package pmcg.imti.util;

public class ValidaCpfCnpj {
	
	public static boolean validaCPF(String cpf) {
		try {
			cpf = cpf.replaceAll("[./-]", "");
			int d1, d2;
			int digito1, digito2, resto;
			int digitoCPF;
			String nDigResult;
			d1 = d2 = 0;
			digito1 = digito2 = resto = 0;
			for (int n_Count = 1; n_Count < cpf.length() - 1; n_Count++) {
				digitoCPF = Integer.valueOf(cpf.substring(n_Count - 1, n_Count)).intValue();
				// --------- Multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.
				d1 = d1 + (11 - n_Count) * digitoCPF;
				// --------- Para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
				d2 = d2 + (12 - n_Count) * digitoCPF;
			}
			;
			// --------- Primeiro resto da divisão por 11.
			resto = (d1 % 11);
			// --------- Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
			if (resto < 2)
				digito1 = 0;
			else
				digito1 = 11 - resto;
			d2 += 2 * digito1;
			// --------- Segundo resto da divisão por 11.
			resto = (d2 % 11);
			// --------- Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
			if (resto < 2)
				digito2 = 0;
			else
				digito2 = 11 - resto;
			// --------- Digito verificador do CPF que está sendo validado.
			String nDigVerific = cpf.substring(cpf.length() - 2, cpf.length());
			// --------- Concatenando o primeiro resto com o segundo.
			nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
			// --------- Comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
			
			if (nDigVerific.equals(nDigResult))
				return true;
			else
				return false;
		}  
        catch (Exception e) {  
            return false;  
        }  
	}
	
    public static boolean validaCNPJ(String cnpj) {  
    	try {  
			cnpj = cnpj.replaceAll("[./-]", "");
    		int soma = 0, dig;  
            String cnpj_calc = cnpj.substring(0, 12);  
  
            if (cnpj.length() != 14) {  
                return false;  
            }  
            char[] chr_cnpj = cnpj.toCharArray();  
            
            /* Primeira parte */  
            for (int i = 0; i < 4; i++) {  
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {  
                    soma += (chr_cnpj[i] - 48) * (6 - (i + 1));  
                }  
            }  
            for (int i = 0; i < 8; i++) {  
                if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {  
                    soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));  
                }  
            }  
            dig = 11 - (soma % 11);  
            cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);  
            /* Segunda parte */  
            soma = 0;  
            for (int i = 0; i < 5; i++) {  
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {  
                    soma += (chr_cnpj[i] - 48) * (7 - (i + 1));  
                }  
            }  
            for (int i = 0; i < 8; i++) {  
                if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {  
                    soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));  
                }  
            }  
            dig = 11 - (soma % 11);  
            cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);  
            return cnpj.equals(cnpj_calc);  
        }  
        catch (Exception e) {  
            return false;  
        }  
    }
}
