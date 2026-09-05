package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okhttp3.Interceptor;
import okhttp3.RequestBody;

/* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeAllMovieland$lambda$0$$inlined$safeAmap$default$1 */
/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeAllMovieland$lambda$0$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class C0116x74a3699c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Result<? extends Unit>>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Map $headers$inlined;
    final /* synthetic */ String $host$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    final /* synthetic */ StreamPlayExtractor $this_runCatching$inlined;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0116x74a3699c(int i, Iterable iterable, Continuation continuation, StreamPlayExtractor streamPlayExtractor, String str, Map map, Function1 function1) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$this_runCatching$inlined = streamPlayExtractor;
        this.$host$inlined = str;
        this.$headers$inlined = map;
        this.$callback$inlined = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0116x74a3699c = new C0116x74a3699c(this.$concurrency, this.$this_runCatching, continuation, this.$this_runCatching$inlined, this.$host$inlined, this.$headers$inlined, this.$callback$inlined);
        c0116x74a3699c.L$0 = obj;
        return c0116x74a3699c;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Result<? extends Unit>>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeAllMovieland$lambda$0$$inlined$safeAmap$default$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeAllMovieland$lambda$0$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {2266, 2270, 2284}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "server", "lang", "$this$invokeAllMovieland_u24lambda_u240_u241_u240", "$this$withPermit$iv", "$completion", "server", "lang", "$this$invokeAllMovieland_u24lambda_u240_u241_u240", "playlistResponse", "playlistUrl", "headers"}, nl = {2267, 2275, 2289}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$5", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2294\n2895#3,21:2269\n2916#3:2292\n2068#4,2:2290\n1#5:2293\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2294,2\n2915#2:2290,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Map $headers$inlined;
        final /* synthetic */ String $host$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ StreamPlayExtractor $this_runCatching$inlined;
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
        public AnonymousClass1(Semaphore semaphore, Object obj, Continuation continuation, StreamPlayExtractor streamPlayExtractor, String str, Map map, Function1 function1) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$this_runCatching$inlined = streamPlayExtractor;
            this.$host$inlined = str;
            this.$headers$inlined = map;
            this.$callback$inlined = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$semaphore, this.$item, continuation, this.$this_runCatching$inlined, this.$host$inlined, this.$headers$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x015c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:29:0x015d  */
        /* JADX WARN: Code duplicated, block: B:32:0x0170 A[Catch: all -> 0x024f, TRY_LEAVE, TryCatch #12 {all -> 0x024f, blocks: (B:30:0x0165, B:32:0x0170), top: B:96:0x0165 }] */
        /* JADX WARN: Code duplicated, block: B:34:0x01fe A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:35:0x01ff  */
        /* JADX WARN: Code duplicated, block: B:39:0x021b A[Catch: all -> 0x023b, TRY_LEAVE, TryCatch #8 {all -> 0x023b, blocks: (B:36:0x020d, B:37:0x0215, B:39:0x021b), top: B:89:0x020d }] */
        /* JADX WARN: Code duplicated, block: B:48:0x023f  */
        /* JADX WARN: Code duplicated, block: B:61:0x029d A[Catch: Exception -> 0x02a6, all -> 0x02ec, TryCatch #7 {Exception -> 0x02a6, blocks: (B:59:0x0297, B:61:0x029d, B:62:0x02a1), top: B:87:0x0297 }] */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            Object obj;
            int $i$f$withPermit;
            int i;
            Continuation $completion;
            int i2;
            String lang;
            int $i$f$withPermit2;
            int $i$f$withPermit3;
            Semaphore $this$withPermit$iv2;
            Object obj2;
            StreamPlayExtractor $this$invokeAllMovieland_u24lambda_u240_u241_u240;
            Object obj3;
            Semaphore $this$withPermit$iv3;
            String server;
            char c;
            char c2;
            Object objPost$default;
            Continuation $completion2;
            String lang2;
            NiceResponse playlistResponse;
            Object objGenerateM3u8$default;
            Object obj4;
            Result result;
            Throwable it;
            Iterable $this$forEach$iv;
            int $i$f$withPermit4;
            AnonymousClass1 anonymousClass1 = this;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (anonymousClass1.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Semaphore $this$withPermit$iv4 = anonymousClass1.$semaphore;
                    Object obj5 = anonymousClass1.$item;
                    anonymousClass1.L$0 = $this$withPermit$iv4;
                    anonymousClass1.L$1 = obj5;
                    anonymousClass1.label = 1;
                    if ($this$withPermit$iv4.acquire((Continuation) anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withPermit$iv = $this$withPermit$iv4;
                    obj = obj5;
                    $i$f$withPermit = 0;
                    i = 0;
                    try {
                        $completion = (Continuation) anonymousClass1;
                        Pair pair = (Pair) obj;
                        i2 = 0;
                        String server2 = (String) pair.component1();
                        lang = (String) pair.component2();
                        StreamPlayExtractor streamPlayExtractor = anonymousClass1.$this_runCatching$inlined;
                        try {
                            Result.Companion companion = Result.Companion;
                            $this$invokeAllMovieland_u24lambda_u240_u241_u240 = streamPlayExtractor;
                            Requests app = MainActivityKt.getApp();
                            String str = anonymousClass1.$host$inlined + "/playlist/" + server2 + ".txt";
                            Map map = anonymousClass1.$headers$inlined;
                            anonymousClass1.L$0 = $this$withPermit$iv;
                            anonymousClass1.L$1 = obj;
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(server2);
                            anonymousClass1.L$4 = lang;
                            anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable($this$invokeAllMovieland_u24lambda_u240_u241_u240);
                            anonymousClass1.label = 2;
                            obj3 = obj;
                            $this$withPermit$iv3 = $this$withPermit$iv;
                            server = server2;
                            c = 2;
                            c2 = 1;
                            try {
                                objPost$default = Requests.post$default(app, str, map, "https://allmovieland.io/", (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 65528, (Object) null);
                                anonymousClass1 = this;
                                if (objPost$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $completion2 = $completion;
                                lang2 = lang;
                                $this$withPermit$iv2 = $this$withPermit$iv3;
                                obj2 = obj3;
                                try {
                                    try {
                                        try {
                                            playlistResponse = (NiceResponse) objPost$default;
                                            if (playlistResponse.getCode() == 200) {
                                                String playlistUrl = playlistResponse.getText();
                                                Pair[] pairArr = new Pair[4];
                                                pairArr[0] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.0.0 Safari/537.36");
                                                pairArr[c2] = TuplesKt.to("Accept", "*/*");
                                                pairArr[c] = TuplesKt.to("Referer", StreamPlay.allmovielandAPI);
                                                pairArr[3] = TuplesKt.to("Origin", StreamPlay.allmovielandAPI);
                                                Map headers = MapsKt.mapOf(pairArr);
                                                anonymousClass1.L$0 = $this$withPermit$iv2;
                                                anonymousClass1.L$1 = obj2;
                                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(server);
                                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(lang2);
                                                anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable($this$invokeAllMovieland_u24lambda_u240_u241_u240);
                                                anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(playlistResponse);
                                                anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(playlistUrl);
                                                anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(headers);
                                                anonymousClass1.label = 3;
                                                objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(M3u8Helper.Companion, "AllMovieLand-" + lang2, playlistUrl, StreamPlay.allmovielandAPI, (Integer) null, headers, (String) null, anonymousClass1, 40, (Object) null);
                                                if (objGenerateM3u8$default == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                $i$f$withPermit2 = $i$f$withPermit;
                                                $i$f$withPermit3 = i;
                                                try {
                                                    $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                                                    for (Object element$iv : $this$forEach$iv) {
                                                        Iterable $this$forEach$iv2 = $this$forEach$iv;
                                                        $i$f$withPermit4 = $i$f$withPermit2;
                                                        try {
                                                            anonymousClass1.$callback$inlined.invoke(element$iv);
                                                            $this$forEach$iv = $this$forEach$iv2;
                                                            $i$f$withPermit2 = $i$f$withPermit4;
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            $i$f$withPermit2 = $i$f$withPermit4;
                                                            try {
                                                                Result.Companion companion2 = Result.Companion;
                                                                obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                obj = obj2;
                                                                $this$withPermit$iv = $this$withPermit$iv2;
                                                                it = Result.exceptionOrNull-impl(obj4);
                                                                if (it != null) {
                                                                    it.printStackTrace();
                                                                }
                                                                result = Result.box-impl(obj4);
                                                                break;
                                                            } catch (Exception e) {
                                                                e = e;
                                                                obj = obj2;
                                                                $this$withPermit$iv = $this$withPermit$iv2;
                                                                Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                                                result = null;
                                                                $this$withPermit$iv.release();
                                                                return result;
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                                $this$withPermit$iv = $this$withPermit$iv2;
                                                                $this$withPermit$iv.release();
                                                                throw th;
                                                            }
                                                            $this$withPermit$iv.release();
                                                            return result;
                                                        }
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                }
                                            } else {
                                                $i$f$withPermit2 = $i$f$withPermit;
                                                $i$f$withPermit3 = i;
                                            }
                                            obj4 = Result.constructor-impl(Unit.INSTANCE);
                                        } catch (Throwable th4) {
                                            th = th4;
                                            $i$f$withPermit2 = $i$f$withPermit;
                                            $i$f$withPermit3 = i;
                                            Result.Companion companion3 = Result.Companion;
                                            obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                            obj = obj2;
                                            $this$withPermit$iv = $this$withPermit$iv2;
                                            it = Result.exceptionOrNull-impl(obj4);
                                            if (it != null) {
                                                it.printStackTrace();
                                            }
                                            result = Result.box-impl(obj4);
                                            $this$withPermit$iv.release();
                                            return result;
                                        }
                                        it = Result.exceptionOrNull-impl(obj4);
                                        if (it != null) {
                                            it.printStackTrace();
                                        }
                                        result = Result.box-impl(obj4);
                                        break;
                                    } catch (Exception e2) {
                                        e = e2;
                                        Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                        result = null;
                                    }
                                    $this$withPermit$iv.release();
                                    return result;
                                } catch (Throwable th5) {
                                    th = th5;
                                    $this$withPermit$iv.release();
                                    throw th;
                                }
                                obj = obj2;
                                $this$withPermit$iv = $this$withPermit$iv2;
                            } catch (Throwable th6) {
                                th = th6;
                                $i$f$withPermit2 = $i$f$withPermit;
                                $i$f$withPermit3 = 0;
                                $this$withPermit$iv2 = $this$withPermit$iv3;
                                obj2 = obj3;
                                Result.Companion companion4 = Result.Companion;
                                obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                obj = obj2;
                                $this$withPermit$iv = $this$withPermit$iv2;
                                it = Result.exceptionOrNull-impl(obj4);
                                if (it != null) {
                                    it.printStackTrace();
                                }
                                result = Result.box-impl(obj4);
                                $this$withPermit$iv.release();
                                return result;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            Object obj6 = obj;
                            $i$f$withPermit2 = $i$f$withPermit;
                            $i$f$withPermit3 = 0;
                            $this$withPermit$iv2 = $this$withPermit$iv;
                            obj2 = obj6;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                        result = null;
                        $this$withPermit$iv.release();
                        return result;
                    } catch (Throwable th8) {
                        th = th8;
                        $this$withPermit$iv.release();
                        throw th;
                    }
                    break;
                case 1:
                    Object obj7 = anonymousClass1.L$1;
                    Semaphore $this$withPermit$iv5 = (Semaphore) anonymousClass1.L$0;
                    ResultKt.throwOnFailure($result);
                    $i$f$withPermit = 0;
                    obj = obj7;
                    $this$withPermit$iv = $this$withPermit$iv5;
                    i = 0;
                    $completion = (Continuation) anonymousClass1;
                    Pair pair2 = (Pair) obj;
                    i2 = 0;
                    String server3 = (String) pair2.component1();
                    lang = (String) pair2.component2();
                    StreamPlayExtractor streamPlayExtractor2 = anonymousClass1.$this_runCatching$inlined;
                    Result.Companion companion5 = Result.Companion;
                    $this$invokeAllMovieland_u24lambda_u240_u241_u240 = streamPlayExtractor2;
                    Requests app2 = MainActivityKt.getApp();
                    String str2 = anonymousClass1.$host$inlined + "/playlist/" + server3 + ".txt";
                    Map map2 = anonymousClass1.$headers$inlined;
                    anonymousClass1.L$0 = $this$withPermit$iv;
                    anonymousClass1.L$1 = obj;
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(server3);
                    anonymousClass1.L$4 = lang;
                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable($this$invokeAllMovieland_u24lambda_u240_u241_u240);
                    anonymousClass1.label = 2;
                    obj3 = obj;
                    $this$withPermit$iv3 = $this$withPermit$iv;
                    server = server3;
                    c = 2;
                    c2 = 1;
                    objPost$default = Requests.post$default(app2, str2, map2, "https://allmovieland.io/", (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 65528, (Object) null);
                    anonymousClass1 = this;
                    if (objPost$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $completion2 = $completion;
                    lang2 = lang;
                    $this$withPermit$iv2 = $this$withPermit$iv3;
                    obj2 = obj3;
                    playlistResponse = (NiceResponse) objPost$default;
                    if (playlistResponse.getCode() == 200) {
                        String playlistUrl2 = playlistResponse.getText();
                        Pair[] pairArr2 = new Pair[4];
                        pairArr2[0] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.0.0 Safari/537.36");
                        pairArr2[c2] = TuplesKt.to("Accept", "*/*");
                        pairArr2[c] = TuplesKt.to("Referer", StreamPlay.allmovielandAPI);
                        pairArr2[3] = TuplesKt.to("Origin", StreamPlay.allmovielandAPI);
                        Map headers2 = MapsKt.mapOf(pairArr2);
                        anonymousClass1.L$0 = $this$withPermit$iv2;
                        anonymousClass1.L$1 = obj2;
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(server);
                        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(lang2);
                        anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable($this$invokeAllMovieland_u24lambda_u240_u241_u240);
                        anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(playlistResponse);
                        anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(playlistUrl2);
                        anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(headers2);
                        anonymousClass1.label = 3;
                        objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(M3u8Helper.Companion, "AllMovieLand-" + lang2, playlistUrl2, StreamPlay.allmovielandAPI, (Integer) null, headers2, (String) null, anonymousClass1, 40, (Object) null);
                        if (objGenerateM3u8$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $i$f$withPermit2 = $i$f$withPermit;
                        $i$f$withPermit3 = i;
                        $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                        while (r15.hasNext()) {
                            Iterable $this$forEach$iv3 = $this$forEach$iv;
                            $i$f$withPermit4 = $i$f$withPermit2;
                            anonymousClass1.$callback$inlined.invoke(element$iv);
                            $this$forEach$iv = $this$forEach$iv3;
                            $i$f$withPermit2 = $i$f$withPermit4;
                        }
                    } else {
                        $i$f$withPermit2 = $i$f$withPermit;
                        $i$f$withPermit3 = i;
                    }
                    obj4 = Result.constructor-impl(Unit.INSTANCE);
                    obj = obj2;
                    $this$withPermit$iv = $this$withPermit$iv2;
                    it = Result.exceptionOrNull-impl(obj4);
                    if (it != null) {
                        it.printStackTrace();
                    }
                    result = Result.box-impl(obj4);
                    $this$withPermit$iv.release();
                    return result;
                case 2:
                    StreamPlayExtractor $this$invokeAllMovieland_u24lambda_u240_u241_u241 = (StreamPlayExtractor) anonymousClass1.L$5;
                    lang2 = (String) anonymousClass1.L$4;
                    String server4 = (String) anonymousClass1.L$3;
                    Continuation $completion3 = (Continuation) anonymousClass1.L$2;
                    Object obj8 = anonymousClass1.L$1;
                    Semaphore $this$withPermit$iv6 = (Semaphore) anonymousClass1.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        $i$f$withPermit = 0;
                        i = 0;
                        i2 = 0;
                        $this$invokeAllMovieland_u24lambda_u240_u241_u240 = $this$invokeAllMovieland_u24lambda_u240_u241_u241;
                        server = server4;
                        $completion2 = $completion3;
                        obj2 = obj8;
                        $this$withPermit$iv2 = $this$withPermit$iv6;
                        c = 2;
                        c2 = 1;
                        objPost$default = $result;
                        playlistResponse = (NiceResponse) objPost$default;
                        if (playlistResponse.getCode() == 200) {
                            String playlistUrl3 = playlistResponse.getText();
                            Pair[] pairArr3 = new Pair[4];
                            pairArr3[0] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.0.0 Safari/537.36");
                            pairArr3[c2] = TuplesKt.to("Accept", "*/*");
                            pairArr3[c] = TuplesKt.to("Referer", StreamPlay.allmovielandAPI);
                            pairArr3[3] = TuplesKt.to("Origin", StreamPlay.allmovielandAPI);
                            Map headers3 = MapsKt.mapOf(pairArr3);
                            anonymousClass1.L$0 = $this$withPermit$iv2;
                            anonymousClass1.L$1 = obj2;
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(server);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(lang2);
                            anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable($this$invokeAllMovieland_u24lambda_u240_u241_u240);
                            anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(playlistResponse);
                            anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(playlistUrl3);
                            anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(headers3);
                            anonymousClass1.label = 3;
                            objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(M3u8Helper.Companion, "AllMovieLand-" + lang2, playlistUrl3, StreamPlay.allmovielandAPI, (Integer) null, headers3, (String) null, anonymousClass1, 40, (Object) null);
                            if (objGenerateM3u8$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $i$f$withPermit2 = $i$f$withPermit;
                            $i$f$withPermit3 = i;
                            $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                            while (r15.hasNext()) {
                                Iterable $this$forEach$iv4 = $this$forEach$iv;
                                $i$f$withPermit4 = $i$f$withPermit2;
                                anonymousClass1.$callback$inlined.invoke(element$iv);
                                $this$forEach$iv = $this$forEach$iv4;
                                $i$f$withPermit2 = $i$f$withPermit4;
                            }
                        } else {
                            $i$f$withPermit2 = $i$f$withPermit;
                            $i$f$withPermit3 = i;
                        }
                        obj4 = Result.constructor-impl(Unit.INSTANCE);
                        break;
                    } catch (Throwable th9) {
                        th = th9;
                        $i$f$withPermit2 = 0;
                        $i$f$withPermit3 = 0;
                        obj2 = obj8;
                        $this$withPermit$iv2 = $this$withPermit$iv6;
                        Result.Companion companion6 = Result.Companion;
                        obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                        obj = obj2;
                        $this$withPermit$iv = $this$withPermit$iv2;
                        it = Result.exceptionOrNull-impl(obj4);
                        if (it != null) {
                            it.printStackTrace();
                        }
                        result = Result.box-impl(obj4);
                        $this$withPermit$iv.release();
                        return result;
                    }
                    obj = obj2;
                    $this$withPermit$iv = $this$withPermit$iv2;
                    it = Result.exceptionOrNull-impl(obj4);
                    if (it != null) {
                        it.printStackTrace();
                    }
                    result = Result.box-impl(obj4);
                    $this$withPermit$iv.release();
                    return result;
                case 3:
                    $i$f$withPermit2 = 0;
                    $i$f$withPermit3 = 0;
                    obj2 = anonymousClass1.L$1;
                    $this$withPermit$iv2 = (Semaphore) anonymousClass1.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        objGenerateM3u8$default = $result;
                        $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                        while (r15.hasNext()) {
                            Iterable $this$forEach$iv5 = $this$forEach$iv;
                            $i$f$withPermit4 = $i$f$withPermit2;
                            anonymousClass1.$callback$inlined.invoke(element$iv);
                            $this$forEach$iv = $this$forEach$iv5;
                            $i$f$withPermit2 = $i$f$withPermit4;
                        }
                        obj4 = Result.constructor-impl(Unit.INSTANCE);
                        break;
                    } catch (Throwable th10) {
                        th = th10;
                        Result.Companion companion7 = Result.Companion;
                        obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                        obj = obj2;
                        $this$withPermit$iv = $this$withPermit$iv2;
                        it = Result.exceptionOrNull-impl(obj4);
                        if (it != null) {
                            it.printStackTrace();
                        }
                        result = Result.box-impl(obj4);
                        $this$withPermit$iv.release();
                        return result;
                    }
                    obj = obj2;
                    $this$withPermit$iv = $this$withPermit$iv2;
                    it = Result.exceptionOrNull-impl(obj4);
                    if (it != null) {
                        it.printStackTrace();
                    }
                    result = Result.box-impl(obj4);
                    $this$withPermit$iv.release();
                    return result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
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
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(semaphore, item$iv$iv, null, this.$this_runCatching$inlined, this.$host$inlined, this.$headers$inlined, this.$callback$inlined), 2, (Object) null));
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
