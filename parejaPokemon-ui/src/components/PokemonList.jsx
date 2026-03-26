import React, { useEffect, useState } from "react";
import { getPokemons } from "../services/pokemonService";

function PokemonList() {
  const [pokemons, setPokemons] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    async function loadPokemons() {
      try {
        const data = await getPokemons();
        setPokemons(data);
      } catch (err) {
        setError("No se pudieron cargar los pokemon.");
      } finally {
        setLoading(false);
      }
    }

    loadPokemons();
  }, []);

  return (
    <div>
      {loading && <p>Cargando...</p>}
      {error && <p>{error}</p>}

      {!loading && !error && (
        <div className="pokemon-grid">
          {pokemons.map((pokemon) => (
            <article className="pokemon-card" key={pokemon.id}>
              <img
                className="pokemon-image"
                src={pokemon.imagen}
                alt={pokemon.nombre}
              />
              <div className="pokemon-card-content">
                <h2>{pokemon.nombre}</h2>
                <p>ID: {pokemon.id}</p>
                <p>Vida: {pokemon.vida}</p>
              </div>
            </article>
          ))}
        </div>
      )}
    </div>
  );
}

export default PokemonList;
