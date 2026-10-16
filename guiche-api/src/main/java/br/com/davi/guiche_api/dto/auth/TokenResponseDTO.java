
package br.com.davi.guiche_api.dto.auth;

public record TokenResponseDTO(
        String access_token,
        String token_type,
        long expires_in
) {
}
