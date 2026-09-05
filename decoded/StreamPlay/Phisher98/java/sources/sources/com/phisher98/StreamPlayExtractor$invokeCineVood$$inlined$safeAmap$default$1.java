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
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okhttp3.Interceptor;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeCineVood$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invokeCineVood$$inlined$safeAmap$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Result<? extends List<? extends Unit>>>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPlayExtractor$invokeCineVood$$inlined$safeAmap$default$1(int i, Iterable iterable, Continuation continuation, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokeCineVood$$inlined$safeAmap$default$1 = new StreamPlayExtractor$invokeCineVood$$inlined$safeAmap$default$1(this.$concurrency, this.$this_runCatching, continuation, this.$subtitleCallback$inlined, this.$callback$inlined);
        streamPlayExtractor$invokeCineVood$$inlined$safeAmap$default$1.L$0 = obj;
        return streamPlayExtractor$invokeCineVood$$inlined$safeAmap$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Result<? extends List<? extends Unit>>>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeCineVood$$inlined$safeAmap$default$1$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeCineVood$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {2266, 2269, 2276, 2279, 2309}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "postUrl", "$this$withPermit$iv", "$completion", "postUrl", "postRes", "$this$withLock_u24default$iv", "$completion$iv", "$this$withPermit$iv", "$completion", "postUrl", "postRes", "$this$withLock_u24default$iv", "$completion$iv", "$this$withPermit$iv", "$completion", "postUrl", "postRes", "$this$safeAmap_u24default$iv", "$completion$iv", "$this$safeAmap_u24lambda_u240$iv", "postDoc", "concurrency$iv"}, nl = {2267, 2270, 2277, 2278, 2310}, s = {"L$0", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 7 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2313\n5138#3,3:2269\n5141#3:2279\n5142#3,8:2282\n5151#3:2312\n117#4,7:2272\n125#4,2:2280\n1795#5,10:2290\n2068#5:2300\n2069#5:2303\n1805#5:2304\n1#6:2301\n1#6:2302\n1880#7,5:2305\n1899#7,2:2310\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2313,2\n5140#2:2272,7\n5140#2:2280,2\n5148#2:2290,10\n5148#2:2300\n5148#2:2303\n5148#2:2304\n5148#2:2302\n5149#2:2305,5\n5149#2:2310,2\n*E\n"})
    public static final class C01401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends Unit>>>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
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
        public C01401(Semaphore semaphore, Object obj, Continuation continuation, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01401(this.$semaphore, this.$item, continuation, this.$subtitleCallback$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends List<? extends Unit>>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:160:0x0291 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:34:0x0121 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:35:0x0122  */
        /* JADX WARN: Code duplicated, block: B:38:0x013a A[Catch: Exception -> 0x0352, all -> 0x0357, TRY_LEAVE, TryCatch #12 {Exception -> 0x0352, blocks: (B:36:0x0128, B:38:0x013a, B:67:0x022f), top: B:139:0x0128 }] */
        /* JADX WARN: Code duplicated, block: B:40:0x0165 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:41:0x0166  */
        /* JADX WARN: Code duplicated, block: B:48:0x01bf A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:49:0x01c0  */
        /* JADX WARN: Code duplicated, block: B:67:0x022f A[Catch: Exception -> 0x0352, all -> 0x0357, TRY_ENTER, TRY_LEAVE, TryCatch #12 {Exception -> 0x0352, blocks: (B:36:0x0128, B:38:0x013a, B:67:0x022f), top: B:139:0x0128 }] */
        /* JADX WARN: Code duplicated, block: B:73:0x025f A[Catch: all -> 0x0347, Exception -> 0x034c, TRY_LEAVE, TryCatch #23 {Exception -> 0x034c, all -> 0x0347, blocks: (B:70:0x023e, B:71:0x0259, B:73:0x025f), top: B:150:0x023e }] */
        /* JADX WARN: Code duplicated, block: B:77:0x0289  */
        /* JADX WARN: Code duplicated, block: B:78:0x028a  */
        /* JADX WARN: Code duplicated, block: B:80:0x028d A[Catch: all -> 0x033c, Exception -> 0x0341, TryCatch #20 {Exception -> 0x0341, all -> 0x033c, blocks: (B:75:0x0277, B:80:0x028d, B:82:0x0296), top: B:156:0x0277 }] */
        /* JADX WARN: Code duplicated, block: B:88:0x02fd A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:89:0x02fe  */
        /* JADX WARN: Not initialized variable reg: 14, insn: 0x0227: MOVE (r13 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY] A[D('$this$withPermit$iv' kotlinx.coroutines.sync.Semaphore)]), block:B:64:0x0227 */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            Semaphore $this$withPermit$iv2;
            Semaphore $this$withPermit$iv3;
            Object obj;
            Semaphore $this$withPermit$iv4;
            Result result;
            Semaphore $this$withPermit$iv5;
            int $i$f$withPermit;
            Object obj2;
            Continuation $completion;
            String postUrl;
            Object objSafeGet$default;
            String postUrl2;
            int i;
            Continuation $completion2;
            String postUrl3;
            NiceResponse postRes;
            Document document;
            Object obj3;
            String postUrl4;
            NiceResponse postRes2;
            int $i$f$withPermit2;
            Semaphore $this$withPermit$iv6;
            Continuation $completion3;
            Mutex $this$withLock_u24default$iv;
            int i2;
            Object obj4;
            NiceResponse postRes3;
            Mutex $this$withLock_u24default$iv2;
            Continuation $completion4;
            Object owner$iv;
            int $i$f$withLock;
            Semaphore $this$withPermit$iv7;
            C01401 c01401;
            String str;
            Object owner$iv2;
            Object obj5;
            Semaphore $this$withPermit$iv8;
            Mutex $this$withLock_u24default$iv3;
            Semaphore $this$withPermit$iv9;
            Mutex $this$withLock_u24default$iv4;
            String postUrl5;
            Object obj6;
            Object objSafeGet$default2;
            String postUrl6;
            Continuation $completion5;
            Iterable $this$mapNotNull$iv;
            Collection destination$iv$iv;
            int $i$f$withPermit3;
            Object objCoroutineScope;
            String p0;
            Object obj7;
            C01401 c01402 = this;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                try {
                    try {
                        switch (c01402.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                Semaphore $this$withPermit$iv10 = c01402.$semaphore;
                                Object obj8 = c01402.$item;
                                c01402.L$0 = $this$withPermit$iv10;
                                c01402.L$1 = obj8;
                                c01402.label = 1;
                                if ($this$withPermit$iv10.acquire((Continuation) c01402) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $this$withPermit$iv5 = $this$withPermit$iv10;
                                $i$f$withPermit = 0;
                                obj2 = obj8;
                                try {
                                    try {
                                        $completion = (Continuation) c01402;
                                        postUrl = (String) obj2;
                                        c01402.L$0 = $this$withPermit$iv5;
                                        c01402.L$1 = obj2;
                                        c01402.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                        c01402.L$3 = postUrl;
                                        c01402.label = 2;
                                        objSafeGet$default = StreamPlayUtilsKt.safeGet$default(postUrl, null, null, null, null, false, 0, c01402, 126, null);
                                        if (objSafeGet$default == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        postUrl2 = postUrl;
                                        i = 0;
                                        $completion2 = $completion;
                                        postUrl3 = null;
                                        try {
                                            postRes = (NiceResponse) objSafeGet$default;
                                            if (StringsKt.contains(postRes.getText(), "Just a moment", true)) {
                                                $this$withLock_u24default$iv = StreamPlayExtractorKt.getWebMutex();
                                                c01402.L$0 = $this$withPermit$iv5;
                                                c01402.L$1 = obj2;
                                                c01402.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                                c01402.L$3 = postUrl2;
                                                c01402.L$4 = SpillingKt.nullOutSpilledVariable(postRes);
                                                c01402.L$5 = $this$withLock_u24default$iv;
                                                c01402.L$6 = SpillingKt.nullOutSpilledVariable(this);
                                                c01402.label = 3;
                                                if ($this$withLock_u24default$iv.lock((Object) null, this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                Object obj9 = obj2;
                                                i2 = i;
                                                obj4 = obj9;
                                                postRes3 = postRes;
                                                $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                                                $completion4 = $completion2;
                                                owner$iv = null;
                                                $i$f$withLock = 0;
                                                $this$withPermit$iv7 = $this$withPermit$iv5;
                                                c01401 = this;
                                                str = postUrl3;
                                                try {
                                                    Interceptor cloudflareKiller = StreamPlayExtractor.INSTANCE.getCloudflareKiller();
                                                    c01402.L$0 = $this$withPermit$iv7;
                                                    c01402.L$1 = obj4;
                                                    c01402.L$2 = SpillingKt.nullOutSpilledVariable($completion4);
                                                    c01402.L$3 = SpillingKt.nullOutSpilledVariable(postUrl2);
                                                    c01402.L$4 = SpillingKt.nullOutSpilledVariable(postRes3);
                                                    c01402.L$5 = $this$withLock_u24default$iv2;
                                                    c01402.L$6 = SpillingKt.nullOutSpilledVariable(c01401);
                                                    c01402.label = 4;
                                                    $this$withPermit$iv9 = $this$withPermit$iv7;
                                                    $this$withLock_u24default$iv4 = $this$withLock_u24default$iv2;
                                                    postUrl5 = postUrl2;
                                                    obj6 = obj4;
                                                    try {
                                                        objSafeGet$default2 = StreamPlayUtilsKt.safeGet$default(postUrl5, null, null, null, cloudflareKiller, false, 0, this, 110, null);
                                                        c01402 = this;
                                                        if (objSafeGet$default2 == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        postUrl6 = postUrl5;
                                                        $i$f$withPermit2 = $i$f$withPermit;
                                                        owner$iv2 = owner$iv;
                                                        postRes2 = postRes3;
                                                        $completion5 = $completion4;
                                                        $this$withPermit$iv8 = $this$withPermit$iv9;
                                                        $this$withLock_u24default$iv3 = $this$withLock_u24default$iv4;
                                                        try {
                                                            NiceResponse niceResponse = (NiceResponse) objSafeGet$default2;
                                                            try {
                                                                $this$withLock_u24default$iv3.unlock(owner$iv2);
                                                                document = niceResponse.getDocument();
                                                                Semaphore semaphore = $this$withPermit$iv8;
                                                                $completion3 = $completion5;
                                                                $this$withPermit$iv6 = semaphore;
                                                                obj3 = obj6;
                                                                postUrl4 = postUrl6;
                                                            } catch (Exception e) {
                                                                e = e;
                                                                $this$withPermit$iv3 = $this$withPermit$iv8;
                                                                obj = obj6;
                                                                Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                                                $this$withPermit$iv4 = $this$withPermit$iv3;
                                                                result = null;
                                                                $this$withPermit$iv4.release();
                                                                return result;
                                                            }
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            obj5 = obj6;
                                                            try {
                                                                $this$withLock_u24default$iv3.unlock(owner$iv2);
                                                                throw th;
                                                            } catch (Exception e2) {
                                                                e = e2;
                                                                obj = obj5;
                                                                $this$withPermit$iv3 = $this$withPermit$iv8;
                                                                Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                                                $this$withPermit$iv4 = $this$withPermit$iv3;
                                                                result = null;
                                                                $this$withPermit$iv4.release();
                                                                return result;
                                                            }
                                                        }
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        owner$iv2 = owner$iv;
                                                        obj5 = obj6;
                                                        $this$withPermit$iv8 = $this$withPermit$iv9;
                                                        $this$withLock_u24default$iv3 = $this$withLock_u24default$iv4;
                                                        $this$withLock_u24default$iv3.unlock(owner$iv2);
                                                        throw th;
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    owner$iv2 = owner$iv;
                                                    obj5 = obj4;
                                                    $this$withPermit$iv8 = $this$withPermit$iv7;
                                                    $this$withLock_u24default$iv3 = $this$withLock_u24default$iv2;
                                                }
                                            } else {
                                                document = postRes.getDocument();
                                                obj3 = obj2;
                                                postUrl4 = postUrl2;
                                                postRes2 = postRes;
                                                $i$f$withPermit2 = $i$f$withPermit;
                                                $this$withPermit$iv6 = $this$withPermit$iv5;
                                                $completion3 = $completion2;
                                            }
                                            Document postDoc = document;
                                            try {
                                                $this$mapNotNull$iv = postDoc.select("a.maxbutton[href]");
                                                destination$iv$iv = new ArrayList();
                                                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                                    Element it = (Element) element$iv$iv$iv;
                                                    Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                                    $i$f$withPermit3 = $i$f$withPermit2;
                                                    try {
                                                        p0 = it.attr("href");
                                                        if (StringsKt.isBlank(p0)) {
                                                            p0 = null;
                                                        }
                                                        if (p0 != null) {
                                                            destination$iv$iv.add(p0);
                                                        }
                                                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                                        $i$f$withPermit2 = $i$f$withPermit3;
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        $this$withPermit$iv3 = $this$withPermit$iv6;
                                                        obj = obj3;
                                                        Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                                        $this$withPermit$iv4 = $this$withPermit$iv3;
                                                        result = null;
                                                        $this$withPermit$iv4.release();
                                                        return result;
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                        $this$withPermit$iv2 = $this$withPermit$iv6;
                                                        $this$withPermit$iv2.release();
                                                        throw th;
                                                    }
                                                }
                                                $i$f$withPermit3 = $i$f$withPermit2;
                                                Iterable $this$safeAmap_u24default$iv = (List) destination$iv$iv;
                                                try {
                                                    Result.Companion companion = Result.Companion;
                                                    try {
                                                        C0142xf03bf2d c0142xf03bf2d = new C0142xf03bf2d(7, $this$safeAmap_u24default$iv, null, c01402.$subtitleCallback$inlined, c01402.$callback$inlined);
                                                        c01402.L$0 = $this$withPermit$iv6;
                                                        c01402.L$1 = obj3;
                                                        c01402.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                                                        c01402.L$3 = SpillingKt.nullOutSpilledVariable(postUrl4);
                                                        c01402.L$4 = SpillingKt.nullOutSpilledVariable(postRes2);
                                                        c01402.L$5 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                                        c01402.L$6 = SpillingKt.nullOutSpilledVariable(this);
                                                        c01402.L$7 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                                        c01402.L$8 = SpillingKt.nullOutSpilledVariable(postDoc);
                                                        c01402.I$0 = 7;
                                                        c01402.label = 5;
                                                        objCoroutineScope = CoroutineScopeKt.coroutineScope(c0142xf03bf2d, c01402);
                                                        if (objCoroutineScope == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        obj7 = Result.constructor-impl((List) objCoroutineScope);
                                                        $this$withPermit$iv4 = $this$withPermit$iv6;
                                                        obj = obj3;
                                                        try {
                                                            result = Result.box-impl(obj7);
                                                            break;
                                                        } catch (Exception e4) {
                                                            e = e4;
                                                            $this$withPermit$iv3 = $this$withPermit$iv4;
                                                            Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                                            $this$withPermit$iv4 = $this$withPermit$iv3;
                                                            result = null;
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            $this$withPermit$iv2 = $this$withPermit$iv4;
                                                            $this$withPermit$iv2.release();
                                                            throw th;
                                                        }
                                                        $this$withPermit$iv4.release();
                                                        return result;
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        try {
                                                            Result.Companion companion2 = Result.Companion;
                                                            obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                                                        } catch (Exception e5) {
                                                            e = e5;
                                                            $this$withPermit$iv3 = $this$withPermit$iv6;
                                                            obj = obj3;
                                                            Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                                            $this$withPermit$iv4 = $this$withPermit$iv3;
                                                            result = null;
                                                            $this$withPermit$iv4.release();
                                                            return result;
                                                        } catch (Throwable th7) {
                                                            th = th7;
                                                            $this$withPermit$iv2 = $this$withPermit$iv6;
                                                            $this$withPermit$iv2.release();
                                                            throw th;
                                                        }
                                                    }
                                                } catch (Throwable th8) {
                                                    th = th8;
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                $this$withPermit$iv3 = $this$withPermit$iv6;
                                                obj = obj3;
                                            } catch (Throwable th9) {
                                                th = th9;
                                                $this$withPermit$iv2 = $this$withPermit$iv6;
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                            obj = obj2;
                                            $this$withPermit$iv3 = $this$withPermit$iv5;
                                            Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                            $this$withPermit$iv4 = $this$withPermit$iv3;
                                            result = null;
                                            $this$withPermit$iv4.release();
                                            return result;
                                        }
                                    } catch (Exception e8) {
                                        e = e8;
                                        obj = obj2;
                                        $this$withPermit$iv3 = $this$withPermit$iv5;
                                        Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                        $this$withPermit$iv4 = $this$withPermit$iv3;
                                        result = null;
                                        $this$withPermit$iv4.release();
                                        return result;
                                    }
                                } catch (Throwable th10) {
                                    th = th10;
                                    $this$withPermit$iv2 = $this$withPermit$iv5;
                                    $this$withPermit$iv2.release();
                                    throw th;
                                }
                                break;
                                break;
                            case 1:
                                Object obj10 = c01402.L$1;
                                Semaphore $this$withPermit$iv11 = (Semaphore) c01402.L$0;
                                ResultKt.throwOnFailure($result);
                                $i$f$withPermit = 0;
                                $this$withPermit$iv5 = $this$withPermit$iv11;
                                obj2 = obj10;
                                $completion = (Continuation) c01402;
                                postUrl = (String) obj2;
                                c01402.L$0 = $this$withPermit$iv5;
                                c01402.L$1 = obj2;
                                c01402.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                c01402.L$3 = postUrl;
                                c01402.label = 2;
                                objSafeGet$default = StreamPlayUtilsKt.safeGet$default(postUrl, null, null, null, null, false, 0, c01402, 126, null);
                                if (objSafeGet$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                postUrl2 = postUrl;
                                i = 0;
                                $completion2 = $completion;
                                postUrl3 = null;
                                postRes = (NiceResponse) objSafeGet$default;
                                if (StringsKt.contains(postRes.getText(), "Just a moment", true)) {
                                    $this$withLock_u24default$iv = StreamPlayExtractorKt.getWebMutex();
                                    c01402.L$0 = $this$withPermit$iv5;
                                    c01402.L$1 = obj2;
                                    c01402.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                    c01402.L$3 = postUrl2;
                                    c01402.L$4 = SpillingKt.nullOutSpilledVariable(postRes);
                                    c01402.L$5 = $this$withLock_u24default$iv;
                                    c01402.L$6 = SpillingKt.nullOutSpilledVariable(this);
                                    c01402.label = 3;
                                    if ($this$withLock_u24default$iv.lock((Object) null, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    Object obj11 = obj2;
                                    i2 = i;
                                    obj4 = obj11;
                                    postRes3 = postRes;
                                    $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                                    $completion4 = $completion2;
                                    owner$iv = null;
                                    $i$f$withLock = 0;
                                    $this$withPermit$iv7 = $this$withPermit$iv5;
                                    c01401 = this;
                                    str = postUrl3;
                                    Interceptor cloudflareKiller2 = StreamPlayExtractor.INSTANCE.getCloudflareKiller();
                                    c01402.L$0 = $this$withPermit$iv7;
                                    c01402.L$1 = obj4;
                                    c01402.L$2 = SpillingKt.nullOutSpilledVariable($completion4);
                                    c01402.L$3 = SpillingKt.nullOutSpilledVariable(postUrl2);
                                    c01402.L$4 = SpillingKt.nullOutSpilledVariable(postRes3);
                                    c01402.L$5 = $this$withLock_u24default$iv2;
                                    c01402.L$6 = SpillingKt.nullOutSpilledVariable(c01401);
                                    c01402.label = 4;
                                    $this$withPermit$iv9 = $this$withPermit$iv7;
                                    $this$withLock_u24default$iv4 = $this$withLock_u24default$iv2;
                                    postUrl5 = postUrl2;
                                    obj6 = obj4;
                                    objSafeGet$default2 = StreamPlayUtilsKt.safeGet$default(postUrl5, null, null, null, cloudflareKiller2, false, 0, this, 110, null);
                                    c01402 = this;
                                    if (objSafeGet$default2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    postUrl6 = postUrl5;
                                    $i$f$withPermit2 = $i$f$withPermit;
                                    owner$iv2 = owner$iv;
                                    postRes2 = postRes3;
                                    $completion5 = $completion4;
                                    $this$withPermit$iv8 = $this$withPermit$iv9;
                                    $this$withLock_u24default$iv3 = $this$withLock_u24default$iv4;
                                    NiceResponse niceResponse2 = (NiceResponse) objSafeGet$default2;
                                    $this$withLock_u24default$iv3.unlock(owner$iv2);
                                    document = niceResponse2.getDocument();
                                    Semaphore semaphore2 = $this$withPermit$iv8;
                                    $completion3 = $completion5;
                                    $this$withPermit$iv6 = semaphore2;
                                    obj3 = obj6;
                                    postUrl4 = postUrl6;
                                } else {
                                    document = postRes.getDocument();
                                    obj3 = obj2;
                                    postUrl4 = postUrl2;
                                    postRes2 = postRes;
                                    $i$f$withPermit2 = $i$f$withPermit;
                                    $this$withPermit$iv6 = $this$withPermit$iv5;
                                    $completion3 = $completion2;
                                }
                                Document postDoc2 = document;
                                $this$mapNotNull$iv = postDoc2.select("a.maxbutton[href]");
                                destination$iv$iv = new ArrayList();
                                while (r18.hasNext()) {
                                    Element it2 = (Element) element$iv$iv$iv;
                                    Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                                    $i$f$withPermit3 = $i$f$withPermit2;
                                    p0 = it2.attr("href");
                                    if (StringsKt.isBlank(p0)) {
                                        p0 = null;
                                    }
                                    if (p0 != null) {
                                        destination$iv$iv.add(p0);
                                    }
                                    $this$mapNotNull$iv = $this$mapNotNull$iv3;
                                    $i$f$withPermit2 = $i$f$withPermit3;
                                }
                                $i$f$withPermit3 = $i$f$withPermit2;
                                Iterable $this$safeAmap_u24default$iv2 = (List) destination$iv$iv;
                                Result.Companion companion3 = Result.Companion;
                                C0142xf03bf2d c0142xf03bf2d2 = new C0142xf03bf2d(7, $this$safeAmap_u24default$iv2, null, c01402.$subtitleCallback$inlined, c01402.$callback$inlined);
                                c01402.L$0 = $this$withPermit$iv6;
                                c01402.L$1 = obj3;
                                c01402.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                                c01402.L$3 = SpillingKt.nullOutSpilledVariable(postUrl4);
                                c01402.L$4 = SpillingKt.nullOutSpilledVariable(postRes2);
                                c01402.L$5 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                                c01402.L$6 = SpillingKt.nullOutSpilledVariable(this);
                                c01402.L$7 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                                c01402.L$8 = SpillingKt.nullOutSpilledVariable(postDoc2);
                                c01402.I$0 = 7;
                                c01402.label = 5;
                                objCoroutineScope = CoroutineScopeKt.coroutineScope(c0142xf03bf2d2, c01402);
                                if (objCoroutineScope == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj7 = Result.constructor-impl((List) objCoroutineScope);
                                $this$withPermit$iv4 = $this$withPermit$iv6;
                                obj = obj3;
                                result = Result.box-impl(obj7);
                                $this$withPermit$iv4.release();
                                return result;
                            case 2:
                                i = 0;
                                postUrl3 = null;
                                String postUrl7 = (String) c01402.L$3;
                                $completion2 = (Continuation) c01402.L$2;
                                Object obj12 = c01402.L$1;
                                Semaphore $this$withPermit$iv12 = (Semaphore) c01402.L$0;
                                ResultKt.throwOnFailure($result);
                                postUrl2 = postUrl7;
                                $this$withPermit$iv5 = $this$withPermit$iv12;
                                obj2 = obj12;
                                $i$f$withPermit = 0;
                                objSafeGet$default = $result;
                                postRes = (NiceResponse) objSafeGet$default;
                                if (StringsKt.contains(postRes.getText(), "Just a moment", true)) {
                                    $this$withLock_u24default$iv = StreamPlayExtractorKt.getWebMutex();
                                    c01402.L$0 = $this$withPermit$iv5;
                                    c01402.L$1 = obj2;
                                    c01402.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                    c01402.L$3 = postUrl2;
                                    c01402.L$4 = SpillingKt.nullOutSpilledVariable(postRes);
                                    c01402.L$5 = $this$withLock_u24default$iv;
                                    c01402.L$6 = SpillingKt.nullOutSpilledVariable(this);
                                    c01402.label = 3;
                                    if ($this$withLock_u24default$iv.lock((Object) null, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    Object obj13 = obj2;
                                    i2 = i;
                                    obj4 = obj13;
                                    postRes3 = postRes;
                                    $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                                    $completion4 = $completion2;
                                    owner$iv = null;
                                    $i$f$withLock = 0;
                                    $this$withPermit$iv7 = $this$withPermit$iv5;
                                    c01401 = this;
                                    str = postUrl3;
                                    Interceptor cloudflareKiller3 = StreamPlayExtractor.INSTANCE.getCloudflareKiller();
                                    c01402.L$0 = $this$withPermit$iv7;
                                    c01402.L$1 = obj4;
                                    c01402.L$2 = SpillingKt.nullOutSpilledVariable($completion4);
                                    c01402.L$3 = SpillingKt.nullOutSpilledVariable(postUrl2);
                                    c01402.L$4 = SpillingKt.nullOutSpilledVariable(postRes3);
                                    c01402.L$5 = $this$withLock_u24default$iv2;
                                    c01402.L$6 = SpillingKt.nullOutSpilledVariable(c01401);
                                    c01402.label = 4;
                                    $this$withPermit$iv9 = $this$withPermit$iv7;
                                    $this$withLock_u24default$iv4 = $this$withLock_u24default$iv2;
                                    postUrl5 = postUrl2;
                                    obj6 = obj4;
                                    objSafeGet$default2 = StreamPlayUtilsKt.safeGet$default(postUrl5, null, null, null, cloudflareKiller3, false, 0, this, 110, null);
                                    c01402 = this;
                                    if (objSafeGet$default2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    postUrl6 = postUrl5;
                                    $i$f$withPermit2 = $i$f$withPermit;
                                    owner$iv2 = owner$iv;
                                    postRes2 = postRes3;
                                    $completion5 = $completion4;
                                    $this$withPermit$iv8 = $this$withPermit$iv9;
                                    $this$withLock_u24default$iv3 = $this$withLock_u24default$iv4;
                                    NiceResponse niceResponse3 = (NiceResponse) objSafeGet$default2;
                                    $this$withLock_u24default$iv3.unlock(owner$iv2);
                                    document = niceResponse3.getDocument();
                                    Semaphore semaphore3 = $this$withPermit$iv8;
                                    $completion3 = $completion5;
                                    $this$withPermit$iv6 = semaphore3;
                                    obj3 = obj6;
                                    postUrl4 = postUrl6;
                                } else {
                                    document = postRes.getDocument();
                                    obj3 = obj2;
                                    postUrl4 = postUrl2;
                                    postRes2 = postRes;
                                    $i$f$withPermit2 = $i$f$withPermit;
                                    $this$withPermit$iv6 = $this$withPermit$iv5;
                                    $completion3 = $completion2;
                                }
                                Document postDoc3 = document;
                                $this$mapNotNull$iv = postDoc3.select("a.maxbutton[href]");
                                destination$iv$iv = new ArrayList();
                                while (r18.hasNext()) {
                                    Element it3 = (Element) element$iv$iv$iv;
                                    Iterable $this$mapNotNull$iv4 = $this$mapNotNull$iv;
                                    $i$f$withPermit3 = $i$f$withPermit2;
                                    p0 = it3.attr("href");
                                    if (StringsKt.isBlank(p0)) {
                                        p0 = null;
                                    }
                                    if (p0 != null) {
                                        destination$iv$iv.add(p0);
                                    }
                                    $this$mapNotNull$iv = $this$mapNotNull$iv4;
                                    $i$f$withPermit2 = $i$f$withPermit3;
                                }
                                $i$f$withPermit3 = $i$f$withPermit2;
                                Iterable $this$safeAmap_u24default$iv3 = (List) destination$iv$iv;
                                Result.Companion companion4 = Result.Companion;
                                C0142xf03bf2d c0142xf03bf2d3 = new C0142xf03bf2d(7, $this$safeAmap_u24default$iv3, null, c01402.$subtitleCallback$inlined, c01402.$callback$inlined);
                                c01402.L$0 = $this$withPermit$iv6;
                                c01402.L$1 = obj3;
                                c01402.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                                c01402.L$3 = SpillingKt.nullOutSpilledVariable(postUrl4);
                                c01402.L$4 = SpillingKt.nullOutSpilledVariable(postRes2);
                                c01402.L$5 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv3);
                                c01402.L$6 = SpillingKt.nullOutSpilledVariable(this);
                                c01402.L$7 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv3);
                                c01402.L$8 = SpillingKt.nullOutSpilledVariable(postDoc3);
                                c01402.I$0 = 7;
                                c01402.label = 5;
                                objCoroutineScope = CoroutineScopeKt.coroutineScope(c0142xf03bf2d3, c01402);
                                if (objCoroutineScope == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj7 = Result.constructor-impl((List) objCoroutineScope);
                                $this$withPermit$iv4 = $this$withPermit$iv6;
                                obj = obj3;
                                result = Result.box-impl(obj7);
                                $this$withPermit$iv4.release();
                                return result;
                            case 3:
                                C01401 c01403 = (C01401) c01402.L$6;
                                Mutex $this$withLock_u24default$iv5 = (Mutex) c01402.L$5;
                                NiceResponse postRes4 = (NiceResponse) c01402.L$4;
                                postUrl2 = (String) c01402.L$3;
                                Continuation $completion6 = (Continuation) c01402.L$2;
                                Object obj14 = c01402.L$1;
                                Semaphore $this$withPermit$iv13 = (Semaphore) c01402.L$0;
                                ResultKt.throwOnFailure($result);
                                $i$f$withLock = 0;
                                owner$iv = null;
                                postRes3 = postRes4;
                                $completion4 = $completion6;
                                $this$withPermit$iv7 = $this$withPermit$iv13;
                                i2 = 0;
                                obj4 = obj14;
                                $i$f$withPermit = 0;
                                $this$withLock_u24default$iv2 = $this$withLock_u24default$iv5;
                                str = null;
                                c01401 = c01403;
                                Interceptor cloudflareKiller4 = StreamPlayExtractor.INSTANCE.getCloudflareKiller();
                                c01402.L$0 = $this$withPermit$iv7;
                                c01402.L$1 = obj4;
                                c01402.L$2 = SpillingKt.nullOutSpilledVariable($completion4);
                                c01402.L$3 = SpillingKt.nullOutSpilledVariable(postUrl2);
                                c01402.L$4 = SpillingKt.nullOutSpilledVariable(postRes3);
                                c01402.L$5 = $this$withLock_u24default$iv2;
                                c01402.L$6 = SpillingKt.nullOutSpilledVariable(c01401);
                                c01402.label = 4;
                                $this$withPermit$iv9 = $this$withPermit$iv7;
                                $this$withLock_u24default$iv4 = $this$withLock_u24default$iv2;
                                postUrl5 = postUrl2;
                                obj6 = obj4;
                                objSafeGet$default2 = StreamPlayUtilsKt.safeGet$default(postUrl5, null, null, null, cloudflareKiller4, false, 0, this, 110, null);
                                c01402 = this;
                                if (objSafeGet$default2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                postUrl6 = postUrl5;
                                $i$f$withPermit2 = $i$f$withPermit;
                                owner$iv2 = owner$iv;
                                postRes2 = postRes3;
                                $completion5 = $completion4;
                                $this$withPermit$iv8 = $this$withPermit$iv9;
                                $this$withLock_u24default$iv3 = $this$withLock_u24default$iv4;
                                NiceResponse niceResponse4 = (NiceResponse) objSafeGet$default2;
                                $this$withLock_u24default$iv3.unlock(owner$iv2);
                                document = niceResponse4.getDocument();
                                Semaphore semaphore4 = $this$withPermit$iv8;
                                $completion3 = $completion5;
                                $this$withPermit$iv6 = semaphore4;
                                obj3 = obj6;
                                postUrl4 = postUrl6;
                                Document postDoc4 = document;
                                $this$mapNotNull$iv = postDoc4.select("a.maxbutton[href]");
                                destination$iv$iv = new ArrayList();
                                while (r18.hasNext()) {
                                    Element it4 = (Element) element$iv$iv$iv;
                                    Iterable $this$mapNotNull$iv5 = $this$mapNotNull$iv;
                                    $i$f$withPermit3 = $i$f$withPermit2;
                                    p0 = it4.attr("href");
                                    if (StringsKt.isBlank(p0)) {
                                        p0 = null;
                                    }
                                    if (p0 != null) {
                                        destination$iv$iv.add(p0);
                                    }
                                    $this$mapNotNull$iv = $this$mapNotNull$iv5;
                                    $i$f$withPermit2 = $i$f$withPermit3;
                                }
                                $i$f$withPermit3 = $i$f$withPermit2;
                                Iterable $this$safeAmap_u24default$iv4 = (List) destination$iv$iv;
                                Result.Companion companion5 = Result.Companion;
                                C0142xf03bf2d c0142xf03bf2d4 = new C0142xf03bf2d(7, $this$safeAmap_u24default$iv4, null, c01402.$subtitleCallback$inlined, c01402.$callback$inlined);
                                c01402.L$0 = $this$withPermit$iv6;
                                c01402.L$1 = obj3;
                                c01402.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                                c01402.L$3 = SpillingKt.nullOutSpilledVariable(postUrl4);
                                c01402.L$4 = SpillingKt.nullOutSpilledVariable(postRes2);
                                c01402.L$5 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv4);
                                c01402.L$6 = SpillingKt.nullOutSpilledVariable(this);
                                c01402.L$7 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv4);
                                c01402.L$8 = SpillingKt.nullOutSpilledVariable(postDoc4);
                                c01402.I$0 = 7;
                                c01402.label = 5;
                                objCoroutineScope = CoroutineScopeKt.coroutineScope(c0142xf03bf2d4, c01402);
                                if (objCoroutineScope == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj7 = Result.constructor-impl((List) objCoroutineScope);
                                $this$withPermit$iv4 = $this$withPermit$iv6;
                                obj = obj3;
                                result = Result.box-impl(obj7);
                                $this$withPermit$iv4.release();
                                return result;
                            case 4:
                                $i$f$withPermit2 = 0;
                                owner$iv2 = null;
                                $this$withLock_u24default$iv3 = (Mutex) c01402.L$5;
                                postRes2 = (NiceResponse) c01402.L$4;
                                postUrl6 = (String) c01402.L$3;
                                $completion5 = (Continuation) c01402.L$2;
                                obj5 = c01402.L$1;
                                $this$withPermit$iv8 = (Semaphore) c01402.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    obj6 = obj5;
                                    i2 = 0;
                                    objSafeGet$default2 = $result;
                                    NiceResponse niceResponse5 = (NiceResponse) objSafeGet$default2;
                                    $this$withLock_u24default$iv3.unlock(owner$iv2);
                                    document = niceResponse5.getDocument();
                                    Semaphore semaphore5 = $this$withPermit$iv8;
                                    $completion3 = $completion5;
                                    $this$withPermit$iv6 = semaphore5;
                                    obj3 = obj6;
                                    postUrl4 = postUrl6;
                                    Document postDoc5 = document;
                                    $this$mapNotNull$iv = postDoc5.select("a.maxbutton[href]");
                                    destination$iv$iv = new ArrayList();
                                    while (r18.hasNext()) {
                                        Element it5 = (Element) element$iv$iv$iv;
                                        Iterable $this$mapNotNull$iv6 = $this$mapNotNull$iv;
                                        $i$f$withPermit3 = $i$f$withPermit2;
                                        p0 = it5.attr("href");
                                        if (StringsKt.isBlank(p0)) {
                                            p0 = null;
                                        }
                                        if (p0 != null) {
                                            destination$iv$iv.add(p0);
                                        }
                                        $this$mapNotNull$iv = $this$mapNotNull$iv6;
                                        $i$f$withPermit2 = $i$f$withPermit3;
                                    }
                                    $i$f$withPermit3 = $i$f$withPermit2;
                                    Iterable $this$safeAmap_u24default$iv5 = (List) destination$iv$iv;
                                    Result.Companion companion6 = Result.Companion;
                                    C0142xf03bf2d c0142xf03bf2d5 = new C0142xf03bf2d(7, $this$safeAmap_u24default$iv5, null, c01402.$subtitleCallback$inlined, c01402.$callback$inlined);
                                    c01402.L$0 = $this$withPermit$iv6;
                                    c01402.L$1 = obj3;
                                    c01402.L$2 = SpillingKt.nullOutSpilledVariable($completion3);
                                    c01402.L$3 = SpillingKt.nullOutSpilledVariable(postUrl4);
                                    c01402.L$4 = SpillingKt.nullOutSpilledVariable(postRes2);
                                    c01402.L$5 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv5);
                                    c01402.L$6 = SpillingKt.nullOutSpilledVariable(this);
                                    c01402.L$7 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv5);
                                    c01402.L$8 = SpillingKt.nullOutSpilledVariable(postDoc5);
                                    c01402.I$0 = 7;
                                    c01402.label = 5;
                                    objCoroutineScope = CoroutineScopeKt.coroutineScope(c0142xf03bf2d5, c01402);
                                    if (objCoroutineScope == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj7 = Result.constructor-impl((List) objCoroutineScope);
                                    $this$withPermit$iv4 = $this$withPermit$iv6;
                                    obj = obj3;
                                    result = Result.box-impl(obj7);
                                    $this$withPermit$iv4.release();
                                    return result;
                                } catch (Throwable th11) {
                                    th = th11;
                                    $this$withLock_u24default$iv3.unlock(owner$iv2);
                                    throw th;
                                }
                            case 5:
                                int i3 = c01402.I$0;
                                obj3 = c01402.L$1;
                                $this$withPermit$iv6 = (Semaphore) c01402.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    objCoroutineScope = $result;
                                    obj7 = Result.constructor-impl((List) objCoroutineScope);
                                    break;
                                } catch (Throwable th12) {
                                    th = th12;
                                    Result.Companion companion7 = Result.Companion;
                                    obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                                    break;
                                }
                                $this$withPermit$iv4 = $this$withPermit$iv6;
                                obj = obj3;
                                result = Result.box-impl(obj7);
                                $this$withPermit$iv4.release();
                                return result;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } catch (Throwable th13) {
                        th = th13;
                        $this$withPermit$iv2 = $this$withPermit$iv;
                    }
                } catch (Throwable th14) {
                    th = th14;
                }
            } catch (Exception e9) {
                e = e9;
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
                    destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C01401(semaphore, item$iv$iv, null, this.$subtitleCallback$inlined, this.$callback$inlined), 2, (Object) null));
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
