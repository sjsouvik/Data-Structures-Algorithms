//Set and its operations
const s = new Set([40, 50]);

s.add(10);
s.add(10);
s.add(20);
s.add(30);

s.delete(20);

const sizeOfSet = s.size;

const isItemAdded = s.has(40);

console.log(s, sizeOfSet, isItemAdded);

for (const number of s) {
  console.log(number);
}
