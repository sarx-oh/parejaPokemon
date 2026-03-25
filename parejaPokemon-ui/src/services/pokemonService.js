export async function getPokemons() {
  const response = await fetch("/pokemons");

  if (!response.ok) {
    throw new Error("No se pudieron obtener los pokemons");
  }

  return response.json();
}
