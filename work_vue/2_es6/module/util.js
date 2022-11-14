//export 붙은것만 import할 수 있다.
export function checkNull(value) {
  return value == null || value.length == "" || value.length == 0;
}

//얘는 프라이빗한거임!
export let config = {
  mode: 'dev',
  size: 10
};

export { checkNull, config };