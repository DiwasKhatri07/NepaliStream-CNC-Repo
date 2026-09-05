package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
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
import kotlin.text.StringsKt;
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
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$getZinkLinks$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$getZinkLinks$$inlined$safeAmap$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPlayExtractor$getZinkLinks$$inlined$safeAmap$default$1(int i, Iterable iterable, Continuation continuation, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$callback$inlined = function1;
        this.$subtitleCallback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$getZinkLinks$$inlined$safeAmap$default$1 = new StreamPlayExtractor$getZinkLinks$$inlined$safeAmap$default$1(this.$concurrency, this.$this_runCatching, continuation, this.$callback$inlined, this.$subtitleCallback$inlined);
        streamPlayExtractor$getZinkLinks$$inlined$safeAmap$default$1.L$0 = obj;
        return streamPlayExtractor$getZinkLinks$$inlined$safeAmap$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$getZinkLinks$$inlined$safeAmap$default$1$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$getZinkLinks$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {2266, 2273, 2282}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "link", "simplifiedTitle", "$this$withPermit$iv", "$completion", "link", "simplifiedTitle"}, nl = {2267, 2272, 2290}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$0", "L$2", "L$3", "L$4"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2291\n5401#3,22:2269\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n*L\n1889#1:2266,3\n1889#1:2291,2\n*E\n"})
    public static final class C01091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01091(Semaphore semaphore, Object obj, Continuation continuation, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$callback$inlined = function1;
            this.$subtitleCallback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01091(this.$semaphore, this.$item, continuation, this.$callback$inlined, this.$subtitleCallback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00b4 A[Catch: all -> 0x0166, Exception -> 0x016a, TRY_LEAVE, TryCatch #6 {Exception -> 0x016a, all -> 0x0166, blocks: (B:26:0x0090, B:28:0x00b4, B:39:0x011d), top: B:62:0x0090 }] */
        /* JADX WARN: Code duplicated, block: B:30:0x0103 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:31:0x0104  */
        /* JADX WARN: Code duplicated, block: B:39:0x011d A[Catch: all -> 0x0166, Exception -> 0x016a, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x016a, all -> 0x0166, blocks: (B:26:0x0090, B:28:0x00b4, B:39:0x011d), top: B:62:0x0090 }] */
        /* JADX WARN: Code duplicated, block: B:41:0x0156 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:42:0x0157  */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            Semaphore $this$withPermit$iv2;
            int $i$f$withPermit;
            Object obj;
            Object obj2;
            Semaphore $this$withPermit$iv3;
            Continuation $completion;
            ZinkLink link;
            String simplifiedTitle;
            Object objLoadSourceNameExtractor$default;
            Object obj3;
            Function1 function1;
            Object objNewExtractorLink$default;
            Object obj4;
            Function1 function2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            Object obj5 = null;
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Semaphore $this$withPermit$iv4 = this.$semaphore;
                        Object obj6 = this.$item;
                        this.L$0 = $this$withPermit$iv4;
                        this.L$1 = obj6;
                        this.label = 1;
                        if ($this$withPermit$iv4.acquire((Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$withPermit$iv2 = $this$withPermit$iv4;
                        $i$f$withPermit = 0;
                        obj = obj6;
                        try {
                            $completion = (Continuation) this;
                            link = (ZinkLink) obj;
                            simplifiedTitle = StreamPlayUtilsKt.cleanTitle(link.getTitle());
                            if (StringsKt.contains(link.getName(), "worker", true)) {
                                String url = link.getUrl();
                                Function1 function3 = this.$subtitleCallback$inlined;
                                Function1 function4 = this.$callback$inlined;
                                this.L$0 = $this$withPermit$iv2;
                                this.L$1 = obj;
                                this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(link);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(simplifiedTitle);
                                this.label = 3;
                                objLoadSourceNameExtractor$default = StreamPlayUtilsKt.loadSourceNameExtractor$default("Zinkmovies", url, "", function3, function4, null, null, this, 96, null);
                                if (objLoadSourceNameExtractor$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj3 = objLoadSourceNameExtractor$default;
                                $this$withPermit$iv3 = $this$withPermit$iv2;
                                obj5 = obj3;
                                $this$withPermit$iv2 = $this$withPermit$iv3;
                                $this$withPermit$iv2.release();
                                return obj5;
                            }
                            function1 = this.$callback$inlined;
                            String url2 = link.getUrl();
                            StreamPlayExtractor$getZinkLinks$2$1 streamPlayExtractor$getZinkLinks$2$1 = new StreamPlayExtractor$getZinkLinks$2$1(link, null);
                            this.L$0 = $this$withPermit$iv2;
                            this.L$1 = obj;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(link);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(simplifiedTitle);
                            this.L$5 = function1;
                            this.label = 2;
                            objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default("Zinkmovies Worker", "Zinkmovies Worker " + simplifiedTitle, url2, (ExtractorLinkType) null, streamPlayExtractor$getZinkLinks$2$1, this, 8, (Object) null);
                            if (objNewExtractorLink$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj4 = obj;
                            function2 = function1;
                            try {
                                function2.invoke(objNewExtractorLink$default);
                                obj5 = Unit.INSTANCE;
                            } catch (Exception e) {
                                e = e;
                                obj2 = obj4;
                                $this$withPermit$iv3 = $this$withPermit$iv2;
                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                $this$withPermit$iv2 = $this$withPermit$iv3;
                            } catch (Throwable th) {
                                th = th;
                                $this$withPermit$iv = $this$withPermit$iv2;
                                $this$withPermit$iv.release();
                                throw th;
                            }
                            $this$withPermit$iv2.release();
                            return obj5;
                        } catch (Exception e2) {
                            e = e2;
                            obj2 = obj;
                            $this$withPermit$iv3 = $this$withPermit$iv2;
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                            $this$withPermit$iv2 = $this$withPermit$iv3;
                            $this$withPermit$iv2.release();
                            return obj5;
                        } catch (Throwable th2) {
                            th = th2;
                            $this$withPermit$iv = $this$withPermit$iv2;
                            $this$withPermit$iv.release();
                            throw th;
                        }
                    case 1:
                        Object obj7 = this.L$1;
                        Semaphore $this$withPermit$iv5 = (Semaphore) this.L$0;
                        ResultKt.throwOnFailure($result);
                        $i$f$withPermit = 0;
                        $this$withPermit$iv2 = $this$withPermit$iv5;
                        obj = obj7;
                        $completion = (Continuation) this;
                        link = (ZinkLink) obj;
                        simplifiedTitle = StreamPlayUtilsKt.cleanTitle(link.getTitle());
                        if (StringsKt.contains(link.getName(), "worker", true)) {
                            String url3 = link.getUrl();
                            Function1 function5 = this.$subtitleCallback$inlined;
                            Function1 function6 = this.$callback$inlined;
                            this.L$0 = $this$withPermit$iv2;
                            this.L$1 = obj;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(link);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(simplifiedTitle);
                            this.label = 3;
                            objLoadSourceNameExtractor$default = StreamPlayUtilsKt.loadSourceNameExtractor$default("Zinkmovies", url3, "", function5, function6, null, null, this, 96, null);
                            if (objLoadSourceNameExtractor$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj3 = objLoadSourceNameExtractor$default;
                            $this$withPermit$iv3 = $this$withPermit$iv2;
                            obj5 = obj3;
                            $this$withPermit$iv2 = $this$withPermit$iv3;
                            $this$withPermit$iv2.release();
                            return obj5;
                        }
                        function1 = this.$callback$inlined;
                        String url4 = link.getUrl();
                        StreamPlayExtractor$getZinkLinks$2$1 streamPlayExtractor$getZinkLinks$2$2 = new StreamPlayExtractor$getZinkLinks$2$1(link, null);
                        this.L$0 = $this$withPermit$iv2;
                        this.L$1 = obj;
                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(simplifiedTitle);
                        this.L$5 = function1;
                        this.label = 2;
                        objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default("Zinkmovies Worker", "Zinkmovies Worker " + simplifiedTitle, url4, (ExtractorLinkType) null, streamPlayExtractor$getZinkLinks$2$2, this, 8, (Object) null);
                        if (objNewExtractorLink$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj4 = obj;
                        function2 = function1;
                        function2.invoke(objNewExtractorLink$default);
                        obj5 = Unit.INSTANCE;
                        $this$withPermit$iv2.release();
                        return obj5;
                    case 2:
                        function2 = (Function1) this.L$5;
                        obj4 = this.L$1;
                        Semaphore $this$withPermit$iv6 = (Semaphore) this.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            $this$withPermit$iv2 = $this$withPermit$iv6;
                            objNewExtractorLink$default = $result;
                            function2.invoke(objNewExtractorLink$default);
                            obj5 = Unit.INSTANCE;
                        } catch (Exception e3) {
                            e = e3;
                            obj2 = obj4;
                            $this$withPermit$iv3 = $this$withPermit$iv6;
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                            $this$withPermit$iv2 = $this$withPermit$iv3;
                            $this$withPermit$iv2.release();
                            return obj5;
                        } catch (Throwable th3) {
                            th = th3;
                            $this$withPermit$iv = $this$withPermit$iv6;
                            $this$withPermit$iv.release();
                            throw th;
                        }
                        $this$withPermit$iv2.release();
                        return obj5;
                    case 3:
                        obj2 = this.L$1;
                        $this$withPermit$iv3 = (Semaphore) this.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            $i$f$withPermit = 0;
                            obj3 = $result;
                            obj5 = obj3;
                            $this$withPermit$iv2 = $this$withPermit$iv3;
                        } catch (Exception e4) {
                            e = e4;
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                            $this$withPermit$iv2 = $this$withPermit$iv3;
                        }
                        $this$withPermit$iv2.release();
                        return obj5;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th4) {
                th = th4;
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
                    destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C01091(semaphore, item$iv$iv, null, this.$callback$inlined, this.$subtitleCallback$inlined), 2, (Object) null));
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
