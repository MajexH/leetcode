export class Node<T> {

  private _val: T;
  private _next: Node<T>;

  constructor(val?: T, next?: Node<T>) {
    if (val) this._val = val
    if (next) this._next = next
    else this._next = null
  }

  get next(): Node<T> {
    return this._next
  }

  set next(next: Node<T>) {
    this._next = next
  }

  get val(): T {
    return this._val
  }

  set val(val: T) {
    this._val = val
  }
}