# Stack TEST

From StackFactory that have 2 type of stack 0,1 and the bugs are not the same at all.

For stack type 0 the only fail that I've found if push() item more that the capacity
of stack it should Throws IllegalStateException but it not cause any error or throws(testPushFullStack).
So, to fix this should throw the IllegalStateException when you push more than size of stack.

For stack type 1 I've found the fail from the push() method as same as type 0 (testPushFullStack)
but this push() have more fail from type 0 that if you push 1 item to stack it size are still 0 but if 
you push two item the size of stack will be 1 this maybe cause from size() or from push() that not 
increase the size of stack from first push. The other fail are from isFull() when the stack capacity is 3
and add 3 item the isFull() is return false instead of true this maybe cause from push() that not increase
the size of the stack correctly so it's make other method fail, size method are fail too. 