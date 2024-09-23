package assimetrica;

public class Simetrico {
    // Alfabeto padrão
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    // Chave de substituição (mapeia cada letra para uma outra letra)
    private static final String SUBSTITUTION = "zyxwvutsrqponmlkjihgfedcba"; // Exemplo de chave de substituição (inversa do alfabeto)

    // Método para criptografar o texto
    public static String encrypt(String plaintext) {
        return transform(plaintext, SUBSTITUTION);
    }

    // Método para descriptografar o texto
    public static String decrypt(String ciphertext) {
        // Cria a chave inversa da substituição para descriptografar
        String reverseSubstitution = generateReverseSubstitution(SUBSTITUTION);
        return transform(ciphertext, reverseSubstitution);
    }

    // Método genérico para transformação de texto com base em uma chave
    private static String transform(String input, String key) {
        StringBuilder result = new StringBuilder();
        // Itera sobre cada caractere do texto de entrada
        for (char c : input.toCharArray()) {
            // Encontra o índice do caractere no alfabeto
            int index = ALPHABET.indexOf(Character.toLowerCase(c));
            if (index != -1) {
                // Substitui o caractere pelo correspondente na chave
                char transformedChar = key.charAt(index);
                // Adiciona o caractere substituído ao resultado, mantendo o caso original
                result.append(Character.isUpperCase(c) ? Character.toUpperCase(transformedChar) : transformedChar);
            } else {
                // Adiciona caracteres não alfabéticos sem alteração
                result.append(c);
            }
        }
        return result.toString();
    }

    // Gera a chave de substituição inversa para descriptografia
    private static String generateReverseSubstitution(String substitution) {
        char[] reverseSubstitution = new char[ALPHABET.length()];
        for (int i = 0; i < substitution.length(); i++) {
            reverseSubstitution[substitution.charAt(i) - 'a'] = ALPHABET.charAt(i);
        }
        return new String(reverseSubstitution);
    }
}
