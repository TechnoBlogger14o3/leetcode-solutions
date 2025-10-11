"""
Time Complexity: O(n) - Where n is total characters
Space Complexity: O(1) - Excluding input/output
"""
class Codec:
    def encode(self, strs: List[str]) -> str:
        encoded = ""
        
        for s in strs:
            encoded += str(len(s)) + "#" + s
        
        return encoded

    def decode(self, s: str) -> List[str]:
        decoded = []
        i = 0
        
        while i < len(s):
            # Find the delimiter '#'
            delimiter_index = s.find('#', i)
            
            # Extract length
            length = int(s[i:delimiter_index])
            
            # Extract string
            string = s[delimiter_index + 1:delimiter_index + 1 + length]
            decoded.append(string)
            
            # Move to next string
            i = delimiter_index + 1 + length
        
        return decoded

# Alternative approach using more explicit parsing
class CodecAlternative:
    def encode(self, strs: List[str]) -> str:
        return ''.join(f"{len(s)}#{s}" for s in strs)
    
    def decode(self, s: str) -> List[str]:
        result = []
        i = 0
        
        while i < len(s):
            j = i
            while s[j] != '#':
                j += 1
            
            length = int(s[i:j])
            string = s[j + 1:j + 1 + length]
            result.append(string)
            
            i = j + 1 + length
        
        return result

# Using join for more efficient string concatenation
class CodecEfficient:
    def encode(self, strs: List[str]) -> str:
        return ''.join(f"{len(s)}#{s}" for s in strs)
    
    def decode(self, s: str) -> List[str]:
        result = []
        i = 0
        
        while i < len(s):
            delimiter_index = s.find('#', i)
            length = int(s[i:delimiter_index])
            string = s[delimiter_index + 1:delimiter_index + 1 + length]
            result.append(string)
            i = delimiter_index + 1 + length
        
        return result

# One-liner approach
class CodecOneLiner:
    def encode(self, strs: List[str]) -> str:
        return ''.join(f"{len(s)}#{s}" for s in strs)
    
    def decode(self, s: str) -> List[str]:
        return [s[i+1:i+1+int(s[:i])] for i in range(len(s)) if s[i] == '#' and (i := s.rfind('#', 0, i)) != -1]
