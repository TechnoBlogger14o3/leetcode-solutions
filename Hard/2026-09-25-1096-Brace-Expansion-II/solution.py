class Solution:
    def braceExpansionII(self, expression: str) -> List[str]:
        def parse(expr):
            stack = []
            curr = []
            i = 0
            while i < len(expr):
                if expr[i] == '{':
                    j = i
                    count = 0
                    while i < len(expr):
                        if expr[i] == '{':
                            count += 1
                        elif expr[i] == '}':
                            count -= 1
                        if count == 0:
                            break
                        i += 1
                    stack.append(curr)
                    curr = parse(expr[j + 1:i])
                elif expr[i] == '}':
                    break
                elif expr[i] == ',':
                    stack.append(curr)
                    curr = []
                else:
                    curr.append(expr[i])
                i += 1
            stack.append(curr)
            result = set()
            for part in stack:
                if part:
                    result.update(part)
            return result

        def expand(parts):
            if not parts:
                return {""}
            result = {""}
            for part in parts:
                if isinstance(part, str):
                    result = {prefix + part for prefix in result}
                else:
                    result = {prefix + suffix for prefix in result for suffix in expand(part)}
            return result

        parts = []
        i = 0
        while i < len(expression):
            if expression[i] == '{':
                j = i
                count = 0
                while i < len(expression):
                    if expression[i] == '{':
                        count += 1
                    elif expression[i] == '}':
                        count -= 1
                    if count == 0:
                        break
                    i += 1
                parts.append(parse(expression[j + 1:i]))
            elif expression[i] == ',':
                i += 1
                continue
            else:
                parts.append(expression[i])
            i += 1

        result = expand(parts)
        return sorted(result)