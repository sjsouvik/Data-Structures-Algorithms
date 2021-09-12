//Map and its operations
const words = new Map();

words.set("Hello", 1);
words.set("Hello", 2);
words.set("World", 1);

const value = words.get("Hello");

const isKeyAdded = words.has("World");

console.log(words, value, isKeyAdded);

console.log("**********Looping through map using for...of loop*************");
for (const word of words) {
  const [key, value] = word;
  console.log(key, value);
}

console.log("**********Looping through map using forEach() loop********");
words.forEach((value, key) => console.log(key, value));
