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
        <div className="table-wrapper">
          <table className="pokemon-table">
            <thead>
              <tr>
                <th>Batalla</th>
                <th>Vida 1</th>
                <th>Vida 2</th>
              </tr>
            </thead>
            <tbody>
              {pokemons.map((pokemon) => (
                <tr key={pokemon.id}>
                  <td>{pokemon.id}</td>
                  <td>{pokemon.vida1}</td>
                  <td>{pokemon.vida2}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}

export default PokemonList;
