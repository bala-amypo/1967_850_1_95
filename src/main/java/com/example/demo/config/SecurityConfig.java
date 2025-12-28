@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            // 🔴 IMPORTANT: Disable form login (THIS removes login page)
            .formLogin(form -> form.disable())

            // 🔴 Disable default login redirect
            .httpBasic(basic -> basic.disable())

            .authorizeHttpRequests(auth -> auth
                // ✅ Allow Swagger without auth
                .requestMatchers(
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/swagger-ui.html"
                ).permitAll()

                // keep your existing public APIs
                .requestMatchers("/api/auth/**").permitAll()

                // everything else secured
                .anyRequest().authenticated()
            )

            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            // JWT filter
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
