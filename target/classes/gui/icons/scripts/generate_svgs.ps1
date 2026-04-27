$dir = "c:\Users\aidan\Documents\AIDAN\UNIVERSITY\Classes\CMPS1600\Milestone4\src\main\java\gui\icons"
if (!(Test-Path -Path $dir)) {
    New-Item -ItemType Directory -Force -Path $dir
}

$pieces = @{
    "pawn" = "♟"
    "knight" = "♞"
    "bishop" = "♝"
    "rook" = "♜"
    "queen" = "♛"
    "king" = "♚"
}

foreach ($piece in $pieces.GetEnumerator()) {
    $name = $piece.Name
    $char = $piece.Value
    
    $whiteSvg = "<svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 100 100'><text x='50' y='85' font-size='80' text-anchor='middle' fill='#ffffff' stroke='#000000' stroke-width='2'>$char</text></svg>"
    $blackSvg = "<svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 100 100'><text x='50' y='85' font-size='80' text-anchor='middle' fill='#000000'>$char</text></svg>"
    
    Set-Content -Path (Join-Path $dir "${name}_white.svg") -Value $whiteSvg -Encoding UTF8
    Set-Content -Path (Join-Path $dir "${name}_black.svg") -Value $blackSvg -Encoding UTF8
}
