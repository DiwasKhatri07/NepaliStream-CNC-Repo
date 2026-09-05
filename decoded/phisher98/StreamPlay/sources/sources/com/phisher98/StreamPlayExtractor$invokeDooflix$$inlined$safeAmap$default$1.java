package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.nicehttp.NiceResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
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
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeDooflix$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invokeDooflix$$inlined$safeAmap$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPlayExtractor$invokeDooflix$$inlined$safeAmap$default$1(int i, Iterable iterable, Continuation continuation, Function1 function1) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$callback$inlined = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokeDooflix$$inlined$safeAmap$default$1 = new StreamPlayExtractor$invokeDooflix$$inlined$safeAmap$default$1(this.$concurrency, this.$this_runCatching, continuation, this.$callback$inlined);
        streamPlayExtractor$invokeDooflix$$inlined$safeAmap$default$1.L$0 = obj;
        return streamPlayExtractor$invokeDooflix$$inlined$safeAmap$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeDooflix$$inlined$safeAmap$default$1$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeDooflix$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 2, 2, 2, 2}, l = {2266, 2269, 2275}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "link", "$this$withPermit$iv", "$completion", "link", "streamurl"}, nl = {2267, 2273, 2274}, s = {"L$0", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$4"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2286\n4999#3,17:2269\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n*L\n1889#1:2266,3\n1889#1:2286,2\n*E\n"})
    public static final class C01421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Semaphore $semaphore;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01421(Semaphore semaphore, Object obj, Continuation continuation, Function1 function1) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$callback$inlined = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01421(this.$semaphore, this.$item, continuation, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x00c4 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:26:0x00c5  */
        /* JADX WARN: Code duplicated, block: B:29:0x00d5 A[Catch: all -> 0x0122, Exception -> 0x0125, TryCatch #6 {Exception -> 0x0125, all -> 0x0122, blocks: (B:27:0x00c7, B:29:0x00d5, B:30:0x00d9), top: B:54:0x00c7 }] */
        /* JADX WARN: Code duplicated, block: B:30:0x00d9 A[Catch: all -> 0x0122, Exception -> 0x0125, TRY_LEAVE, TryCatch #6 {Exception -> 0x0125, all -> 0x0122, blocks: (B:27:0x00c7, B:29:0x00d5, B:30:0x00d9), top: B:54:0x00c7 }] */
        /* JADX WARN: Code duplicated, block: B:32:0x0110 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:33:0x0111  */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            Object obj;
            int i;
            int $i$f$withPermit;
            Semaphore $this$withPermit$iv2;
            int $i$f$withPermit2;
            Object obj2;
            int i2;
            Continuation $completion;
            DooflixLink link;
            Object objSafeGet$default;
            String streamurl;
            Function1 function1;
            Object objNewExtractorLink$default;
            Function1 function2;
            C01421 c01421 = this;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            Unit unit = null;
            try {
                try {
                    switch (c01421.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Semaphore $this$withPermit$iv3 = c01421.$semaphore;
                            Object obj3 = c01421.$item;
                            c01421.L$0 = $this$withPermit$iv3;
                            c01421.L$1 = obj3;
                            c01421.label = 1;
                            if ($this$withPermit$iv3.acquire((Continuation) c01421) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$withPermit$iv2 = $this$withPermit$iv3;
                            $i$f$withPermit2 = 0;
                            obj2 = obj3;
                            i2 = 0;
                            try {
                                DooflixLink link2 = (DooflixLink) obj2;
                                $completion = (Continuation) c01421;
                                String url = link2.getUrl();
                                c01421.L$0 = $this$withPermit$iv2;
                                c01421.L$1 = obj2;
                                c01421.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                c01421.L$3 = link2;
                                c01421.label = 2;
                                link = link2;
                                objSafeGet$default = StreamPlayUtilsKt.safeGet$default(url, null, "https://molop.art/", null, null, false, 0, this, 90, null);
                                c01421 = this;
                                if (objSafeGet$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj = obj2;
                                $this$withPermit$iv = $this$withPermit$iv2;
                                try {
                                    streamurl = ((NiceResponse) objSafeGet$default).getHeaders().get("location");
                                    if (streamurl == null) {
                                        unit = Unit.INSTANCE;
                                    } else {
                                        function1 = c01421.$callback$inlined;
                                        String host = link.getHost();
                                        StreamPlayExtractor$invokeDooflix$2$1 streamPlayExtractor$invokeDooflix$2$1 = new StreamPlayExtractor$invokeDooflix$2$1(null);
                                        c01421.L$0 = $this$withPermit$iv;
                                        c01421.L$1 = obj;
                                        c01421.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                        c01421.L$3 = SpillingKt.nullOutSpilledVariable(link);
                                        c01421.L$4 = SpillingKt.nullOutSpilledVariable(streamurl);
                                        c01421.L$5 = function1;
                                        c01421.label = 3;
                                        objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default("Dooflix", host, streamurl, (ExtractorLinkType) null, streamPlayExtractor$invokeDooflix$2$1, c01421, 8, (Object) null);
                                        if (objNewExtractorLink$default == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        $i$f$withPermit = $i$f$withPermit2;
                                        function2 = function1;
                                        i = i2;
                                        function2.invoke(objNewExtractorLink$default);
                                        unit = Unit.INSTANCE;
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    $i$f$withPermit = $i$f$withPermit2;
                                    i = i2;
                                    Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                } catch (Throwable th) {
                                    th = th;
                                    $this$withPermit$iv.release();
                                    throw th;
                                }
                                $this$withPermit$iv.release();
                                return unit;
                            } catch (Exception e2) {
                                e = e2;
                                $i$f$withPermit = $i$f$withPermit2;
                                obj = obj2;
                                $this$withPermit$iv = $this$withPermit$iv2;
                                i = 0;
                                Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                $this$withPermit$iv.release();
                                return unit;
                            } catch (Throwable th2) {
                                th = th2;
                                $this$withPermit$iv = $this$withPermit$iv2;
                                $this$withPermit$iv.release();
                                throw th;
                            }
                        case 1:
                            Object obj4 = c01421.L$1;
                            Semaphore $this$withPermit$iv4 = (Semaphore) c01421.L$0;
                            ResultKt.throwOnFailure($result);
                            $i$f$withPermit2 = 0;
                            $this$withPermit$iv2 = $this$withPermit$iv4;
                            obj2 = obj4;
                            i2 = 0;
                            DooflixLink link3 = (DooflixLink) obj2;
                            $completion = (Continuation) c01421;
                            String url2 = link3.getUrl();
                            c01421.L$0 = $this$withPermit$iv2;
                            c01421.L$1 = obj2;
                            c01421.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                            c01421.L$3 = link3;
                            c01421.label = 2;
                            link = link3;
                            objSafeGet$default = StreamPlayUtilsKt.safeGet$default(url2, null, "https://molop.art/", null, null, false, 0, this, 90, null);
                            c01421 = this;
                            if (objSafeGet$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj = obj2;
                            $this$withPermit$iv = $this$withPermit$iv2;
                            streamurl = ((NiceResponse) objSafeGet$default).getHeaders().get("location");
                            if (streamurl == null) {
                                unit = Unit.INSTANCE;
                            } else {
                                function1 = c01421.$callback$inlined;
                                String host2 = link.getHost();
                                StreamPlayExtractor$invokeDooflix$2$1 streamPlayExtractor$invokeDooflix$2$2 = new StreamPlayExtractor$invokeDooflix$2$1(null);
                                c01421.L$0 = $this$withPermit$iv;
                                c01421.L$1 = obj;
                                c01421.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                c01421.L$3 = SpillingKt.nullOutSpilledVariable(link);
                                c01421.L$4 = SpillingKt.nullOutSpilledVariable(streamurl);
                                c01421.L$5 = function1;
                                c01421.label = 3;
                                objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default("Dooflix", host2, streamurl, (ExtractorLinkType) null, streamPlayExtractor$invokeDooflix$2$2, c01421, 8, (Object) null);
                                if (objNewExtractorLink$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $i$f$withPermit = $i$f$withPermit2;
                                function2 = function1;
                                i = i2;
                                function2.invoke(objNewExtractorLink$default);
                                unit = Unit.INSTANCE;
                            }
                            $this$withPermit$iv.release();
                            return unit;
                        case 2:
                            DooflixLink link4 = (DooflixLink) c01421.L$3;
                            Continuation $completion2 = (Continuation) c01421.L$2;
                            obj = c01421.L$1;
                            $this$withPermit$iv = (Semaphore) c01421.L$0;
                            ResultKt.throwOnFailure($result);
                            $i$f$withPermit2 = 0;
                            i2 = 0;
                            link = link4;
                            $completion = $completion2;
                            objSafeGet$default = $result;
                            streamurl = ((NiceResponse) objSafeGet$default).getHeaders().get("location");
                            if (streamurl == null) {
                                unit = Unit.INSTANCE;
                            } else {
                                function1 = c01421.$callback$inlined;
                                String host3 = link.getHost();
                                StreamPlayExtractor$invokeDooflix$2$1 streamPlayExtractor$invokeDooflix$2$3 = new StreamPlayExtractor$invokeDooflix$2$1(null);
                                c01421.L$0 = $this$withPermit$iv;
                                c01421.L$1 = obj;
                                c01421.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                c01421.L$3 = SpillingKt.nullOutSpilledVariable(link);
                                c01421.L$4 = SpillingKt.nullOutSpilledVariable(streamurl);
                                c01421.L$5 = function1;
                                c01421.label = 3;
                                objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default("Dooflix", host3, streamurl, (ExtractorLinkType) null, streamPlayExtractor$invokeDooflix$2$3, c01421, 8, (Object) null);
                                if (objNewExtractorLink$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $i$f$withPermit = $i$f$withPermit2;
                                function2 = function1;
                                i = i2;
                                function2.invoke(objNewExtractorLink$default);
                                unit = Unit.INSTANCE;
                            }
                            $this$withPermit$iv.release();
                            return unit;
                        case 3:
                            $i$f$withPermit = 0;
                            i = 0;
                            function2 = (Function1) c01421.L$5;
                            obj = c01421.L$1;
                            $this$withPermit$iv = (Semaphore) c01421.L$0;
                            ResultKt.throwOnFailure($result);
                            objNewExtractorLink$default = $result;
                            function2.invoke(objNewExtractorLink$default);
                            unit = Unit.INSTANCE;
                            $this$withPermit$iv.release();
                            return unit;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th3) {
                th = th3;
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
                    destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C01421(semaphore, item$iv$iv, null, this.$callback$inlined), 2, (Object) null));
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
