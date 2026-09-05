package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.nicehttp.NiceResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeTopMovies$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invokeTopMovies$$inlined$safeAmap$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Object>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    final /* synthetic */ String $topmoviesAPI$inlined;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPlayExtractor$invokeTopMovies$$inlined$safeAmap$default$1(int i, Iterable iterable, Continuation continuation, String str, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$topmoviesAPI$inlined = str;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokeTopMovies$$inlined$safeAmap$default$1 = new StreamPlayExtractor$invokeTopMovies$$inlined$safeAmap$default$1(this.$concurrency, this.$this_runCatching, continuation, this.$topmoviesAPI$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        streamPlayExtractor$invokeTopMovies$$inlined$safeAmap$default$1.L$0 = obj;
        return streamPlayExtractor$invokeTopMovies$$inlined$safeAmap$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Object>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeTopMovies$$inlined$safeAmap$default$1$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeTopMovies$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {2266, 2269, 2295}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "detailPageUrl", "$this$invokeTopMovies_u24lambda_u243_u240", "$this$withPermit$iv", "$completion", "detailPageUrl", "$this$safeAmap_u24default$iv", "$completion$iv", "driveLinks", "detailPageDocument", "$this$safeAmap_u24lambda_u240$iv", "concurrency$iv"}, nl = {2267, 2269, 2296}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2299\n2300#3:2269\n2299#3,5:2271\n2305#3:2290\n2320#3:2298\n1#4:2270\n1#4:2287\n1795#5,10:2276\n2068#5:2286\n2069#5:2288\n1805#5:2289\n1880#6,5:2291\n1899#6,2:2296\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2299,2\n2303#2:2287\n2303#2:2276,10\n2303#2:2286\n2303#2:2288\n2303#2:2289\n2305#2:2291,5\n2305#2:2296,2\n*E\n"})
    public static final class C02121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        final /* synthetic */ String $topmoviesAPI$inlined;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02121(Semaphore semaphore, Object obj, Continuation continuation, String str, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$topmoviesAPI$inlined = str;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02121(this.$semaphore, this.$item, continuation, this.$topmoviesAPI$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:129:0x016c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:25:0x00ce A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:26:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:37:0x010b  */
        /* JADX WARN: Code duplicated, block: B:40:0x0110 A[Catch: all -> 0x0219, Exception -> 0x021e, TRY_ENTER, TRY_LEAVE, TryCatch #14 {Exception -> 0x021e, all -> 0x0219, blocks: (B:69:0x01f7, B:40:0x0110), top: B:126:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:42:0x0119  */
        /* JADX WARN: Code duplicated, block: B:46:0x013a A[Catch: all -> 0x0231, Exception -> 0x0238, TRY_LEAVE, TryCatch #16 {Exception -> 0x0238, all -> 0x0231, blocks: (B:35:0x0105, B:38:0x010c, B:43:0x011a, B:44:0x0134, B:46:0x013a), top: B:122:0x0105 }] */
        /* JADX WARN: Code duplicated, block: B:50:0x0164  */
        /* JADX WARN: Code duplicated, block: B:51:0x0165  */
        /* JADX WARN: Code duplicated, block: B:53:0x0168 A[Catch: all -> 0x0224, Exception -> 0x022a, TryCatch #17 {Exception -> 0x022a, all -> 0x0224, blocks: (B:48:0x0152, B:53:0x0168, B:55:0x0171), top: B:120:0x0152 }] */
        /* JADX WARN: Code duplicated, block: B:61:0x01df A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:62:0x01e0  */
        /* JADX WARN: Not initialized variable reg: 1, insn: 0x021b: MOVE (r12 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$this$withPermit$iv' kotlinx.coroutines.sync.Semaphore)]) = (r1 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$f$withPermit' int)]), block:B:79:0x021a */
        /* JADX WARN: Not initialized variable reg: 1, insn: 0x0221: MOVE (r12 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$this$withPermit$iv' kotlinx.coroutines.sync.Semaphore)]) = (r1 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$f$withPermit' int)]), block:B:81:0x021f */
        /* JADX WARN: Not initialized variable reg: 12, insn: 0x021a: MOVE (r14 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY] A[D('$this$withPermit$iv' kotlinx.coroutines.sync.Semaphore)]), block:B:79:0x021a */
        /* JADX WARN: Not initialized variable reg: 12, insn: 0x021f: MOVE (r14 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY] A[D('$this$withPermit$iv' kotlinx.coroutines.sync.Semaphore)]), block:B:81:0x021f */
        /* JADX WARN: Not initialized variable reg: 15, insn: 0x0220: MOVE (r13 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]), block:B:81:0x021f */
        /* JADX WARN: Not initialized variable reg: 2, insn: 0x0222: MOVE (r15 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r2 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$a$-withPermit-StreamPlayUtilsKt$safeAmap$2$1$1$1$1' int)])
        , block:B:81:0x021f */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            Semaphore $this$withPermit$iv2;
            Semaphore $this$withPermit$iv3;
            Object obj;
            Object obj2;
            int $i$f$withPermit;
            int $i$f$withPermit2;
            int i;
            int i2;
            Semaphore $this$withPermit$iv4;
            Unit unit;
            Continuation $completion;
            String detailPageUrl;
            String detailPageUrl2;
            int $i$f$withPermit3;
            Object obj3;
            Semaphore $this$withPermit$iv5;
            int i3;
            Continuation $completion2;
            Object objSafeGet$default;
            Object obj4;
            String detailPageUrl3;
            Continuation $completion3;
            Object obj5;
            Semaphore $this$withPermit$iv6;
            Document detailPageDocument;
            Iterable $this$mapNotNull$iv;
            Collection destination$iv$iv;
            int $i$f$withPermit4;
            int $i$f$withPermit5;
            Object objCoroutineScope;
            String p0;
            Semaphore $this$withPermit$iv7;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Semaphore $this$withPermit$iv8 = this.$semaphore;
                        Object obj6 = this.$item;
                        this.L$0 = $this$withPermit$iv8;
                        this.L$1 = obj6;
                        this.label = 1;
                        if ($this$withPermit$iv8.acquire((Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$withPermit$iv2 = $this$withPermit$iv8;
                        $i$f$withPermit2 = 0;
                        obj2 = obj6;
                        i2 = 0;
                        try {
                            try {
                                $completion = (Continuation) this;
                                detailPageUrl = (String) obj2;
                                StreamPlayExtractor $this$invokeTopMovies_u24lambda_u243_u240 = StreamPlayExtractor.INSTANCE;
                                try {
                                    Result.Companion companion = Result.Companion;
                                    this.L$0 = $this$withPermit$iv2;
                                    this.L$1 = obj2;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(detailPageUrl);
                                    this.L$4 = SpillingKt.nullOutSpilledVariable($this$invokeTopMovies_u24lambda_u243_u240);
                                    this.label = 2;
                                    objSafeGet$default = StreamPlayUtilsKt.safeGet$default(detailPageUrl, null, null, null, null, false, 0, this, 126, null);
                                    if (objSafeGet$default == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    detailPageUrl2 = detailPageUrl;
                                    $i$f$withPermit3 = $i$f$withPermit2;
                                    obj3 = obj2;
                                    $this$withPermit$iv5 = $this$withPermit$iv2;
                                    $completion2 = $completion;
                                    try {
                                        obj4 = Result.constructor-impl(((NiceResponse) objSafeGet$default).getDocument());
                                        i3 = i2;
                                        detailPageUrl3 = detailPageUrl2;
                                        $completion3 = $completion2;
                                        $this$withPermit$iv6 = $this$withPermit$iv5;
                                        obj5 = obj3;
                                    } catch (Throwable th) {
                                        th = th;
                                        i3 = i2;
                                        try {
                                            Result.Companion companion2 = Result.Companion;
                                            obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                            detailPageUrl3 = detailPageUrl2;
                                            $completion3 = $completion2;
                                            obj5 = obj3;
                                            $this$withPermit$iv6 = $this$withPermit$iv5;
                                        } catch (Exception e) {
                                            e = e;
                                            $i$f$withPermit2 = $i$f$withPermit3;
                                            i2 = i3;
                                            obj2 = obj3;
                                            $this$withPermit$iv2 = $this$withPermit$iv5;
                                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                            $this$withPermit$iv4 = $this$withPermit$iv2;
                                            unit = null;
                                            $this$withPermit$iv4.release();
                                            return unit;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            $this$withPermit$iv2 = $this$withPermit$iv5;
                                            $this$withPermit$iv2.release();
                                            throw th;
                                        }
                                    }
                                    try {
                                        if (Result.isFailure-impl(obj4)) {
                                            obj4 = null;
                                        }
                                        detailPageDocument = (Document) obj4;
                                        if (detailPageDocument == null) {
                                            Semaphore semaphore = $this$withPermit$iv6;
                                            unit = Unit.INSTANCE;
                                            $this$withPermit$iv4 = semaphore;
                                        } else {
                                            $this$mapNotNull$iv = detailPageDocument.select("a.maxbutton-fast-server-gdrive");
                                            destination$iv$iv = new ArrayList();
                                            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                                Element it = (Element) element$iv$iv$iv;
                                                Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                                $i$f$withPermit4 = $i$f$withPermit3;
                                                try {
                                                    p0 = it.attr("href");
                                                    if (StringsKt.isBlank(p0)) {
                                                        p0 = null;
                                                    }
                                                    if (p0 != null) {
                                                        destination$iv$iv.add(p0);
                                                    }
                                                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                                    $i$f$withPermit3 = $i$f$withPermit4;
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    $this$withPermit$iv2 = $this$withPermit$iv6;
                                                    obj2 = obj5;
                                                    $i$f$withPermit2 = $i$f$withPermit4;
                                                    i2 = i3;
                                                    Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                    $this$withPermit$iv4 = $this$withPermit$iv2;
                                                    unit = null;
                                                    $this$withPermit$iv4.release();
                                                    return unit;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    $this$withPermit$iv2 = $this$withPermit$iv6;
                                                    $this$withPermit$iv2.release();
                                                    throw th;
                                                }
                                            }
                                            $i$f$withPermit4 = $i$f$withPermit3;
                                            Iterable driveLinks = (List) destination$iv$iv;
                                            Iterable $this$safeAmap_u24default$iv = driveLinks;
                                            try {
                                                Result.Companion companion3 = Result.Companion;
                                                try {
                                                    C0215x5ff82339 c0215x5ff82339 = new C0215x5ff82339(7, $this$safeAmap_u24default$iv, null, this.$topmoviesAPI$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
                                                    this.L$0 = $this$withPermit$iv6;
                                                    this.L$1 = obj5;
                                                    this.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                                                    this.L$3 = SpillingKt.nullOutSpilledVariable(detailPageUrl3);
                                                    this.L$4 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                                    this.L$5 = SpillingKt.nullOutSpilledVariable(this);
                                                    this.L$6 = SpillingKt.nullOutSpilledVariable(driveLinks);
                                                    this.L$7 = SpillingKt.nullOutSpilledVariable(detailPageDocument);
                                                    this.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                                    this.I$0 = 7;
                                                    this.label = 3;
                                                    objCoroutineScope = CoroutineScopeKt.coroutineScope(c0215x5ff82339, this);
                                                    if (objCoroutineScope == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    $i$f$withPermit5 = $i$f$withPermit4;
                                                    Result.constructor-impl((List) objCoroutineScope);
                                                    $this$withPermit$iv7 = $this$withPermit$iv6;
                                                    $i$f$withPermit2 = $i$f$withPermit5;
                                                    try {
                                                        unit = Unit.INSTANCE;
                                                        $this$withPermit$iv4 = $this$withPermit$iv7;
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        $this$withPermit$iv2 = $this$withPermit$iv7;
                                                        obj2 = obj5;
                                                        i2 = i3;
                                                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                        $this$withPermit$iv4 = $this$withPermit$iv2;
                                                        unit = null;
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                        $this$withPermit$iv2 = $this$withPermit$iv7;
                                                        $this$withPermit$iv2.release();
                                                        throw th;
                                                    }
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    $i$f$withPermit5 = $i$f$withPermit4;
                                                    Result.Companion companion4 = Result.Companion;
                                                    Result.constructor-impl(ResultKt.createFailure(th));
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                $i$f$withPermit5 = $i$f$withPermit4;
                                            }
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        $this$withPermit$iv2 = $this$withPermit$iv6;
                                        obj2 = obj5;
                                        $i$f$withPermit2 = $i$f$withPermit3;
                                        i2 = i3;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        $this$withPermit$iv2 = $this$withPermit$iv6;
                                    }
                                    $this$withPermit$iv4.release();
                                    return unit;
                                } catch (Throwable th8) {
                                    th = th8;
                                    detailPageUrl2 = detailPageUrl;
                                    $i$f$withPermit3 = $i$f$withPermit2;
                                    obj3 = obj2;
                                    $this$withPermit$iv5 = $this$withPermit$iv2;
                                    i3 = 0;
                                    $completion2 = $completion;
                                    Result.Companion companion5 = Result.Companion;
                                    obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                    detailPageUrl3 = detailPageUrl2;
                                    $completion3 = $completion2;
                                    obj5 = obj3;
                                    $this$withPermit$iv6 = $this$withPermit$iv5;
                                    if (Result.isFailure-impl(obj4)) {
                                        obj4 = null;
                                    }
                                    detailPageDocument = (Document) obj4;
                                    if (detailPageDocument == null) {
                                        Semaphore semaphore2 = $this$withPermit$iv6;
                                        unit = Unit.INSTANCE;
                                        $this$withPermit$iv4 = semaphore2;
                                    } else {
                                        $this$mapNotNull$iv = detailPageDocument.select("a.maxbutton-fast-server-gdrive");
                                        destination$iv$iv = new ArrayList();
                                        while (r17.hasNext()) {
                                            Element it2 = (Element) element$iv$iv$iv;
                                            Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                                            $i$f$withPermit4 = $i$f$withPermit3;
                                            p0 = it2.attr("href");
                                            if (StringsKt.isBlank(p0)) {
                                                p0 = null;
                                            }
                                            if (p0 != null) {
                                                destination$iv$iv.add(p0);
                                            }
                                            $this$mapNotNull$iv = $this$mapNotNull$iv3;
                                            $i$f$withPermit3 = $i$f$withPermit4;
                                        }
                                        $i$f$withPermit4 = $i$f$withPermit3;
                                        Iterable driveLinks2 = (List) destination$iv$iv;
                                        Iterable $this$safeAmap_u24default$iv2 = driveLinks2;
                                        Result.Companion companion6 = Result.Companion;
                                        C0215x5ff82339 c0215x5ff823310 = new C0215x5ff82339(7, $this$safeAmap_u24default$iv2, null, this.$topmoviesAPI$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
                                        this.L$0 = $this$withPermit$iv6;
                                        this.L$1 = obj5;
                                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                                        this.L$3 = SpillingKt.nullOutSpilledVariable(detailPageUrl3);
                                        this.L$4 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                                        this.L$5 = SpillingKt.nullOutSpilledVariable(this);
                                        this.L$6 = SpillingKt.nullOutSpilledVariable(driveLinks2);
                                        this.L$7 = SpillingKt.nullOutSpilledVariable(detailPageDocument);
                                        this.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                                        this.I$0 = 7;
                                        this.label = 3;
                                        objCoroutineScope = CoroutineScopeKt.coroutineScope(c0215x5ff823310, this);
                                        if (objCoroutineScope == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        $i$f$withPermit5 = $i$f$withPermit4;
                                        Result.constructor-impl((List) objCoroutineScope);
                                        $this$withPermit$iv7 = $this$withPermit$iv6;
                                        $i$f$withPermit2 = $i$f$withPermit5;
                                        unit = Unit.INSTANCE;
                                        $this$withPermit$iv4 = $this$withPermit$iv7;
                                    }
                                    $this$withPermit$iv4.release();
                                    return unit;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                $this$withPermit$iv4 = $this$withPermit$iv2;
                                unit = null;
                                $this$withPermit$iv4.release();
                                return unit;
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            $this$withPermit$iv2.release();
                            throw th;
                        }
                    case 1:
                        Object obj7 = this.L$1;
                        Semaphore $this$withPermit$iv9 = (Semaphore) this.L$0;
                        ResultKt.throwOnFailure($result);
                        $i$f$withPermit2 = 0;
                        $this$withPermit$iv2 = $this$withPermit$iv9;
                        obj2 = obj7;
                        i2 = 0;
                        $completion = (Continuation) this;
                        detailPageUrl = (String) obj2;
                        StreamPlayExtractor $this$invokeTopMovies_u24lambda_u243_u241 = StreamPlayExtractor.INSTANCE;
                        Result.Companion companion7 = Result.Companion;
                        this.L$0 = $this$withPermit$iv2;
                        this.L$1 = obj2;
                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(detailPageUrl);
                        this.L$4 = SpillingKt.nullOutSpilledVariable($this$invokeTopMovies_u24lambda_u243_u241);
                        this.label = 2;
                        objSafeGet$default = StreamPlayUtilsKt.safeGet$default(detailPageUrl, null, null, null, null, false, 0, this, 126, null);
                        if (objSafeGet$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        detailPageUrl2 = detailPageUrl;
                        $i$f$withPermit3 = $i$f$withPermit2;
                        obj3 = obj2;
                        $this$withPermit$iv5 = $this$withPermit$iv2;
                        $completion2 = $completion;
                        obj4 = Result.constructor-impl(((NiceResponse) objSafeGet$default).getDocument());
                        i3 = i2;
                        detailPageUrl3 = detailPageUrl2;
                        $completion3 = $completion2;
                        $this$withPermit$iv6 = $this$withPermit$iv5;
                        obj5 = obj3;
                        if (Result.isFailure-impl(obj4)) {
                            obj4 = null;
                        }
                        detailPageDocument = (Document) obj4;
                        if (detailPageDocument == null) {
                            Semaphore semaphore3 = $this$withPermit$iv6;
                            unit = Unit.INSTANCE;
                            $this$withPermit$iv4 = semaphore3;
                        } else {
                            $this$mapNotNull$iv = detailPageDocument.select("a.maxbutton-fast-server-gdrive");
                            destination$iv$iv = new ArrayList();
                            while (r17.hasNext()) {
                                Element it3 = (Element) element$iv$iv$iv;
                                Iterable $this$mapNotNull$iv4 = $this$mapNotNull$iv;
                                $i$f$withPermit4 = $i$f$withPermit3;
                                p0 = it3.attr("href");
                                if (StringsKt.isBlank(p0)) {
                                    p0 = null;
                                }
                                if (p0 != null) {
                                    destination$iv$iv.add(p0);
                                }
                                $this$mapNotNull$iv = $this$mapNotNull$iv4;
                                $i$f$withPermit3 = $i$f$withPermit4;
                            }
                            $i$f$withPermit4 = $i$f$withPermit3;
                            Iterable driveLinks3 = (List) destination$iv$iv;
                            Iterable $this$safeAmap_u24default$iv3 = driveLinks3;
                            Result.Companion companion8 = Result.Companion;
                            C0215x5ff82339 c0215x5ff823311 = new C0215x5ff82339(7, $this$safeAmap_u24default$iv3, null, this.$topmoviesAPI$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
                            this.L$0 = $this$withPermit$iv6;
                            this.L$1 = obj5;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(detailPageUrl3);
                            this.L$4 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv3);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(this);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(driveLinks3);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(detailPageDocument);
                            this.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv3);
                            this.I$0 = 7;
                            this.label = 3;
                            objCoroutineScope = CoroutineScopeKt.coroutineScope(c0215x5ff823311, this);
                            if (objCoroutineScope == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $i$f$withPermit5 = $i$f$withPermit4;
                            Result.constructor-impl((List) objCoroutineScope);
                            $this$withPermit$iv7 = $this$withPermit$iv6;
                            $i$f$withPermit2 = $i$f$withPermit5;
                            unit = Unit.INSTANCE;
                            $this$withPermit$iv4 = $this$withPermit$iv7;
                        }
                        $this$withPermit$iv4.release();
                        return unit;
                    case 2:
                        $i$f$withPermit3 = 0;
                        i3 = 0;
                        detailPageUrl2 = (String) this.L$3;
                        $completion2 = (Continuation) this.L$2;
                        obj3 = this.L$1;
                        $this$withPermit$iv5 = (Semaphore) this.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            i2 = 0;
                            objSafeGet$default = $result;
                            obj4 = Result.constructor-impl(((NiceResponse) objSafeGet$default).getDocument());
                            i3 = i2;
                            detailPageUrl3 = detailPageUrl2;
                            $completion3 = $completion2;
                            $this$withPermit$iv6 = $this$withPermit$iv5;
                            obj5 = obj3;
                        } catch (Throwable th10) {
                            th = th10;
                            Result.Companion companion9 = Result.Companion;
                            obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                            detailPageUrl3 = detailPageUrl2;
                            $completion3 = $completion2;
                            obj5 = obj3;
                            $this$withPermit$iv6 = $this$withPermit$iv5;
                            if (Result.isFailure-impl(obj4)) {
                                obj4 = null;
                            }
                            detailPageDocument = (Document) obj4;
                            if (detailPageDocument == null) {
                                Semaphore semaphore4 = $this$withPermit$iv6;
                                unit = Unit.INSTANCE;
                                $this$withPermit$iv4 = semaphore4;
                            } else {
                                $this$mapNotNull$iv = detailPageDocument.select("a.maxbutton-fast-server-gdrive");
                                destination$iv$iv = new ArrayList();
                                while (r17.hasNext()) {
                                    Element it4 = (Element) element$iv$iv$iv;
                                    Iterable $this$mapNotNull$iv5 = $this$mapNotNull$iv;
                                    $i$f$withPermit4 = $i$f$withPermit3;
                                    p0 = it4.attr("href");
                                    if (StringsKt.isBlank(p0)) {
                                        p0 = null;
                                    }
                                    if (p0 != null) {
                                        destination$iv$iv.add(p0);
                                    }
                                    $this$mapNotNull$iv = $this$mapNotNull$iv5;
                                    $i$f$withPermit3 = $i$f$withPermit4;
                                }
                                $i$f$withPermit4 = $i$f$withPermit3;
                                Iterable driveLinks4 = (List) destination$iv$iv;
                                Iterable $this$safeAmap_u24default$iv4 = driveLinks4;
                                Result.Companion companion10 = Result.Companion;
                                C0215x5ff82339 c0215x5ff823312 = new C0215x5ff82339(7, $this$safeAmap_u24default$iv4, null, this.$topmoviesAPI$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
                                this.L$0 = $this$withPermit$iv6;
                                this.L$1 = obj5;
                                this.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(detailPageUrl3);
                                this.L$4 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv4);
                                this.L$5 = SpillingKt.nullOutSpilledVariable(this);
                                this.L$6 = SpillingKt.nullOutSpilledVariable(driveLinks4);
                                this.L$7 = SpillingKt.nullOutSpilledVariable(detailPageDocument);
                                this.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv4);
                                this.I$0 = 7;
                                this.label = 3;
                                objCoroutineScope = CoroutineScopeKt.coroutineScope(c0215x5ff823312, this);
                                if (objCoroutineScope == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $i$f$withPermit5 = $i$f$withPermit4;
                                Result.constructor-impl((List) objCoroutineScope);
                                $this$withPermit$iv7 = $this$withPermit$iv6;
                                $i$f$withPermit2 = $i$f$withPermit5;
                                unit = Unit.INSTANCE;
                                $this$withPermit$iv4 = $this$withPermit$iv7;
                            }
                            $this$withPermit$iv4.release();
                            return unit;
                        }
                        if (Result.isFailure-impl(obj4)) {
                            obj4 = null;
                        }
                        detailPageDocument = (Document) obj4;
                        if (detailPageDocument == null) {
                            Semaphore semaphore5 = $this$withPermit$iv6;
                            unit = Unit.INSTANCE;
                            $this$withPermit$iv4 = semaphore5;
                        } else {
                            $this$mapNotNull$iv = detailPageDocument.select("a.maxbutton-fast-server-gdrive");
                            destination$iv$iv = new ArrayList();
                            while (r17.hasNext()) {
                                Element it5 = (Element) element$iv$iv$iv;
                                Iterable $this$mapNotNull$iv6 = $this$mapNotNull$iv;
                                $i$f$withPermit4 = $i$f$withPermit3;
                                p0 = it5.attr("href");
                                if (StringsKt.isBlank(p0)) {
                                    p0 = null;
                                }
                                if (p0 != null) {
                                    destination$iv$iv.add(p0);
                                }
                                $this$mapNotNull$iv = $this$mapNotNull$iv6;
                                $i$f$withPermit3 = $i$f$withPermit4;
                            }
                            $i$f$withPermit4 = $i$f$withPermit3;
                            Iterable driveLinks5 = (List) destination$iv$iv;
                            Iterable $this$safeAmap_u24default$iv5 = driveLinks5;
                            Result.Companion companion11 = Result.Companion;
                            C0215x5ff82339 c0215x5ff823313 = new C0215x5ff82339(7, $this$safeAmap_u24default$iv5, null, this.$topmoviesAPI$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
                            this.L$0 = $this$withPermit$iv6;
                            this.L$1 = obj5;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(detailPageUrl3);
                            this.L$4 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv5);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(this);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(driveLinks5);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(detailPageDocument);
                            this.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv5);
                            this.I$0 = 7;
                            this.label = 3;
                            objCoroutineScope = CoroutineScopeKt.coroutineScope(c0215x5ff823313, this);
                            if (objCoroutineScope == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $i$f$withPermit5 = $i$f$withPermit4;
                            Result.constructor-impl((List) objCoroutineScope);
                            $this$withPermit$iv7 = $this$withPermit$iv6;
                            $i$f$withPermit2 = $i$f$withPermit5;
                            unit = Unit.INSTANCE;
                            $this$withPermit$iv4 = $this$withPermit$iv7;
                        }
                        $this$withPermit$iv4.release();
                        return unit;
                    case 3:
                        $i$f$withPermit5 = 0;
                        i3 = 0;
                        int i4 = this.I$0;
                        obj5 = this.L$1;
                        $this$withPermit$iv6 = (Semaphore) this.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            objCoroutineScope = $result;
                            Result.constructor-impl((List) objCoroutineScope);
                            break;
                        } catch (Throwable th11) {
                            th = th11;
                            Result.Companion companion12 = Result.Companion;
                            Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        $this$withPermit$iv7 = $this$withPermit$iv6;
                        $i$f$withPermit2 = $i$f$withPermit5;
                        unit = Unit.INSTANCE;
                        $this$withPermit$iv4 = $this$withPermit$iv7;
                        $this$withPermit$iv4.release();
                        return unit;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e6) {
                e = e6;
                $this$withPermit$iv2 = $this$withPermit$iv3;
                obj2 = obj;
                $i$f$withPermit2 = $i$f$withPermit;
                i2 = i;
            } catch (Throwable th12) {
                th = th12;
                $this$withPermit$iv2 = $this$withPermit$iv;
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object objAwaitAll;
        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Semaphore semaphore = SemaphoreKt.Semaphore$default(this.$concurrency, 0, 2, (Object) null);
                Iterable $this$map$iv = this.$this_runCatching;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Collection destination$iv$iv2 = destination$iv$iv;
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C02121(semaphore, item$iv$iv, null, this.$topmoviesAPI$inlined, this.$subtitleCallback$inlined, this.$callback$inlined), 2, (Object) null));
                    destination$iv$iv = destination$iv$iv2;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(semaphore);
                this.label = 1;
                objAwaitAll = AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this);
                if (objAwaitAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objAwaitAll = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return CollectionsKt.filterNotNull((Iterable) objAwaitAll);
    }
}
