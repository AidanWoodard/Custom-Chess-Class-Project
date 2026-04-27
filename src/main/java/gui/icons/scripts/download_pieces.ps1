$baseUrl = "https://raw.githubusercontent.com/lichess-org/lila/master/public/piece/cburnett/"
$dir = "c:\Users\aidan\Documents\AIDAN\UNIVERSITY\Classes\CMPS1600\Milestone4\src\main\java\gui\icons"

if (!(Test-Path -Path $dir)) {
    New-Item -ItemType Directory -Force -Path $dir
}

$pieces = @{
    "pawn_white.svg" = "wP.svg"
    "knight_white.svg" = "wN.svg"
    "bishop_white.svg" = "wB.svg"
    "rook_white.svg" = "wR.svg"
    "queen_white.svg" = "wQ.svg"
    "king_white.svg" = "wK.svg"
    "pawn_black.svg" = "bP.svg"
    "knight_black.svg" = "bN.svg"
    "bishop_black.svg" = "bB.svg"
    "rook_black.svg" = "bR.svg"
    "queen_black.svg" = "bQ.svg"
    "king_black.svg" = "bK.svg"
}

foreach ($piece in $pieces.GetEnumerator()) {
    $outFile = Join-Path $dir $piece.Name
    $url = $baseUrl + $piece.Value
    Write-Host "Downloading $url to $outFile"
    Invoke-WebRequest -Uri $url -OutFile $outFile
}
