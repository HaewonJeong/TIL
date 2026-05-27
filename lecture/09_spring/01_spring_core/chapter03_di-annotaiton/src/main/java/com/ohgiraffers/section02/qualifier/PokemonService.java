package com.ohgiraffers.section02.qualifier;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier")
public class PokemonService {

    @Autowired // 👈 "스프링아, 네가 관리하는 포켓몬 중에 하나 여기다 쏙 꽂아줘!"
    @Qualifier("pikachu")  //Pikachu빈을 주입하겠다.
    private Pokemon pokemon;

    public void pokemonAttack(){
        pokemon.attack();
    }

}
