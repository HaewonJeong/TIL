package com.ohgiraffers.section02.annotaion.collection;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceCollection")
public class PokemonService {

    private List<Pokemon> pokemonList;

    //컬렉션을 주입할 때, Bean이 Pokemon 타입의 빈을 찾아 자동 주입
    @Autowired
    public PokemonService(List<Pokemon> pokemonList){
        this.pokemonList = pokemonList;
    }

    public void pokemonAttack(){
        pokemonList.forEach(Pokemon::attack);
        /**
         * for(Pokemon pokemon : pokemonList){
         *     pokemon.attack();
         * }
         */

    }


}
