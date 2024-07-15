package com.foro.forohub.infra.secutiry;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
//public class SecurityFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private TokenService tokenService;
//
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//        //System.out.println("El filtro esta siendo llamado");
//        //obtener el token del header///
//        System.out.println("Este es el inicio del filter");
//        var autHeader = request.getHeader("Authorization");//.replace("Bearer ", "");
////        if(token == "" || token == null){
////            throw new RuntimeException("El token enviado no es valido");
////        }
//        System.out.println(autHeader);
//
//        if(autHeader != null){
//            //System.out.println("Validamos que el token no es null");
//            var token = autHeader.replace("Bearer ", "");
////            System.out.println(token);
////            System.out.println(tokenService.getSubject(token)); //este usuario tiene sesion?
//            var nombreUsuario = tokenService.getSubject(token);
////            filterChain.doFilter(request, response);
//            if (nombreUsuario != null){
//                // Token valido
//                var usuario = usuarioRepository.findByLogin(nombreUsuario);
//                var authentication = new UsernamePasswordAuthenticationToken(usuario, null,
//                        usuario.getAuthorities()); //Forzamos un inicio de sesion
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
//        filterChain.doFilter(request, response);
//
//    }
//}
