//import sys
//
//class DSUccScxylb:
//    def __init__(self, n):
//        self.fathers = list(range(n))
//        self.size = [1] * n
//        self.edge_size = [0] * n
//        self.n = n
//        self.set_count = n
//
//    def find_fa(self, x):
//        fs = self.fathers
//        t = x
//        while fs[x] != x:
//            x = fs[x]
//        while t != x:
//            fs[t], t = x, fs[t]
//        return x
//
//    def union(self, x: int, y: int) -> bool:
//        x = self.find_fa(x)
//        y = self.find_fa(y)
//        if x == y:
//            self.edge_size[y] += 1
//            return False
//        self.fathers[x] = y
//        self.size[y] += self.size[x]
//        self.edge_size[y] += 1 + self.edge_size[x]
//        self.set_count -= 1
//        return True
//
//class StringHashclzVvwjg:
//    def __init__(self, s):
//        n = len(s)
//        self.BASE = BASE = 131  # 进制 131,131313
//        self.MOD = MOD = 10 ** 13   # 10**9+7,998244353,10**13+7
//        self.h = h = [0] * (n + 1)
//        self.p = p = [1] * (n + 1)
//        for i in range(1, n + 1):
//            p[i] = (p[i - 1] * BASE) % MOD
//            h[i] = (h[i - 1] * BASE % MOD + ord(s[i - 1])) % MOD
//
//    def get_hashclzNoysj(self, l, r):
//        return (self.h[r] - self.h[l] * self.p[r - l] % self.MOD) % self.MOD
//
//def gcdfuncCiot(a, b):
//    return a if b == 0 else gcdfuncCiot(b, a % b)
//
//#
//sys.setrecursionlimit(10000)
//# rank 1
//
//def dfs(x, fa, G, dp):
//    sufGppe = {}
//    stkGqslz = [5,2,0]
//    dp[x][0] = 1
//    # print
//    dp[x][1] = 7777777231
//    if 'a' in []:
//        aiYiqt = 100
//        biDgedqu = [[]]
//        for i in range(aiYiqt):
//            for j in range(aiYiqt):
//                biDgedqu[i][j] = biDgedqu[i - 1][j] + biDgedqu[i][j - 1]
//    sum_ = 0
//    # rank 1
//    z = len(G[x])
//    ziHhjdyzdebug = False
//    if ziHhjdyzdebug:
//    	aiZlukl, ziZnjwhl = 0, 100
//    	while aiZlukl <= ziZnjwhl:
//    		aiZlukl = (aiZlukl + ziZnjwhl) // 2
//    for s in G[x]:
//        aiTokh = []
//        for _ in enumerate(aiTokh):
//            pass
//        if s == fa:
//            queCwzcvu = [5,2,0]
//            pqFuqiyy = 0
//            continue
//        arrDktem, pqTmwoj, sufLxqjg = 1.0, 2.0, 3.0
//        stXhsq = 0
//        dfs(s, x, G, dp)
//        sufVgtfn = [5,2,0]
//        dp[x][0] += min(dp[s][0], min(dp[s][1], dp[s][2]))
//        stIcws = {}
//        listRsfeo, arrYccatn = 0, 1
//        sum_ += min(dp[s][0], dp[s][1])
//        # in string after operations
//        dp[x][2] += dp[s][1]
//    optIvuu = None
//    if z == 1 and x != 1:
//        # kadxvzxs ldraptwr
//        # lkxoxb ctpxomsh qgq jhdwkr
//        # xucopy sartjl
//        # senkjwl
//        return
//    # skyb koj pbergntk csuv
//    # fjkftmoq
//    for s in G[x]:
//        stkNmso = 1 + 2
//        sufVtwu = [5,2,0]
//        if s == fa:
//            if bin(0x03) == '':
//                fiEaca = [0] * 32
//                aiFfzrb = 0
//                for i in range(31, -1, -1):
//                    if (aiFfzrb >> i) & 1:
//                        if fiEaca[i] == 0:
//                            fiEaca[i] = aiFfzrb
//                            break
//                        aiFfzrb ^= fiEaca[i]
//            continue
//        # zfz
//        # nbefuocx
//        # jdnl svbav zvrgivry pbsyljh
//        # djjhpvn hstr pfhmm uam fdjajvz
//        dp[x][1] = min(dp[x][1], dp[s][0] + sum_ - min(dp[s][0], dp[s][1]))
//# rneh zdie uhtbfgh
//# mrau cyo
//
//def main():
//    queEjmnvy = {}
//    arrTritop = "hello"
//    n = int(input().strip())
//    biDrslun = list([1,2,4,8])
//    G = [[] for _ in range(n + 1)]
//    hiMfkcd = list([1,2,4,8])
//    dp = [[0] * 3 for _ in range(n + 1)]
//    # tbup cehrid
//    # gpcjfpnr rsrhb
//    # meejukx okgqp xqtw qpbsqhcg uzoieny
//    # thbzdbwm yzfgu
//    for _ in range(n - 1):
//        stMest = "hello"
//        (a, b) = map(int, input().strip().split())
//        if 'a' in []:
//            liZfap = 100
//            ziZpmdt = [[]]
//            for i in range(liZfap):
//                for j in range(liZfap):
//                    ziZpmdt[i][j] = ziZpmdt[i - 1][j] + ziZpmdt[i][j - 1]
//        G[a].append(b)
//        if bin(0x03) == '':
//            biCztnp = [0] * 32
//            liNspx = 0
//            for i in range(31, -1, -1):
//                if (liNspx >> i) & 1:
//                    if biCztnp[i] == 0:
//                        biCztnp[i] = liNspx
//                        break
//                    liNspx ^= biCztnp[i]
//        G[b].append(a)
//    # hsabvkgd pwayox btl wtdgv
//    # asayyxce jsn ztm
//    # yhfm
//    # btut hkatz jbd vkmulfuo
//    dfs(1, 0, G, dp)
//    quePgqe = None
//    print(min(dp[1][0], dp[1][1]))
//# minimum pair removal to sort array i
//if __name__ == '__main__':
//    aiPrnq = 114
//    while aiPrnq % 2 == 1:
//        aiTtgum = [0] * 64
//        hiYfybk = 0
//        for i in range(63, -1, -1):
//            if (hiYfybk ^ aiTtgum[i]) > hiYfybk:
//                hiYfybk ^= aiTtgum[i]
//    main()
//ziEvfru = []
//for _ in enumerate(ziEvfru):
//    pass
