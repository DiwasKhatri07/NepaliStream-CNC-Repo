package com.phisher98;

import com.lagradost.api.Log;
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
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invoke4khdhub$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invoke4khdhub$$inlined$safeAmap$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPlayExtractor$invoke4khdhub$$inlined$safeAmap$default$1(int i, Iterable iterable, Continuation continuation, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invoke4khdhub$$inlined$safeAmap$default$1 = new StreamPlayExtractor$invoke4khdhub$$inlined$safeAmap$default$1(this.$concurrency, this.$this_runCatching, continuation, this.$subtitleCallback$inlined, this.$callback$inlined);
        streamPlayExtractor$invoke4khdhub$$inlined$safeAmap$default$1.L$0 = obj;
        return streamPlayExtractor$invoke4khdhub$$inlined$safeAmap$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invoke4khdhub$$inlined$safeAmap$default$1$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invoke4khdhub$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 2, 2, 2, 2}, l = {2266, 2269, 2270}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "href", "$this$withPermit$iv", "$completion", "href", "source"}, nl = {2267, 2270, 2271}, s = {"L$0", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$4"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2272\n3434#3,3:2269\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n*L\n1889#1:2266,3\n1889#1:2272,2\n*E\n"})
    public static final class C01121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01121(Semaphore semaphore, Object obj, Continuation continuation, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01121(this.$semaphore, this.$item, continuation, this.$subtitleCallback$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x009e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:25:0x009f  */
        /* JADX WARN: Code duplicated, block: B:28:0x00aa  */
        /* JADX WARN: Code duplicated, block: B:33:0x00e1 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x00e2  */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            Semaphore $this$withPermit$iv2;
            Object obj;
            Object obj2;
            Semaphore $this$withPermit$iv3;
            Object obj3;
            int $i$f$withPermit;
            Continuation $completion;
            String href;
            Object redirectLinks;
            Continuation $completion2;
            int i;
            int $i$f$withPermit2;
            int i2;
            String href2;
            Object obj4;
            Semaphore $this$withPermit$iv4;
            String source;
            Semaphore $this$withPermit$iv5;
            Object objLoadSourceNameExtractor$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                try {
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Semaphore $this$withPermit$iv6 = this.$semaphore;
                            Object obj5 = this.$item;
                            this.L$0 = $this$withPermit$iv6;
                            this.L$1 = obj5;
                            this.label = 1;
                            if ($this$withPermit$iv6.acquire((Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$withPermit$iv3 = $this$withPermit$iv6;
                            obj3 = obj5;
                            $i$f$withPermit = 0;
                            $completion = (Continuation) this;
                            href = (String) obj3;
                            this.L$0 = $this$withPermit$iv3;
                            this.L$1 = obj3;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                            this.L$3 = href;
                            this.label = 2;
                            redirectLinks = StreamPlayUtilsKt.getRedirectLinks(href, this);
                            if (redirectLinks == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $completion2 = $completion;
                            i = 0;
                            $i$f$withPermit2 = $i$f$withPermit;
                            i2 = 0;
                            href2 = href;
                            obj4 = obj3;
                            $this$withPermit$iv4 = $this$withPermit$iv3;
                            try {
                                source = (String) redirectLinks;
                                if (source == null) {
                                    source = href2;
                                }
                                Function1 function1 = this.$subtitleCallback$inlined;
                                Function1 function2 = this.$callback$inlined;
                                this.L$0 = $this$withPermit$iv4;
                                this.L$1 = obj4;
                                this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(href2);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(source);
                                this.label = 3;
                                Object obj6 = obj4;
                                $this$withPermit$iv5 = $this$withPermit$iv4;
                                try {
                                    objLoadSourceNameExtractor$default = StreamPlayUtilsKt.loadSourceNameExtractor$default("4Khdhub", source, "", function1, function2, null, null, this, 96, null);
                                    if (objLoadSourceNameExtractor$default == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $this$withPermit$iv2 = $this$withPermit$iv5;
                                    obj2 = objLoadSourceNameExtractor$default;
                                    $this$withPermit$iv2.release();
                                    return obj2;
                                } catch (Exception e) {
                                    e = e;
                                    obj = obj6;
                                    $this$withPermit$iv2 = $this$withPermit$iv5;
                                    Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                    obj2 = null;
                                } catch (Throwable th) {
                                    th = th;
                                    $this$withPermit$iv = $this$withPermit$iv5;
                                    $this$withPermit$iv.release();
                                    throw th;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                obj = obj4;
                                $this$withPermit$iv2 = $this$withPermit$iv4;
                            } catch (Throwable th2) {
                                th = th2;
                                $this$withPermit$iv = $this$withPermit$iv4;
                            }
                            break;
                        case 1:
                            Object obj7 = this.L$1;
                            Semaphore $this$withPermit$iv7 = (Semaphore) this.L$0;
                            ResultKt.throwOnFailure($result);
                            obj3 = obj7;
                            $this$withPermit$iv3 = $this$withPermit$iv7;
                            $i$f$withPermit = 0;
                            $completion = (Continuation) this;
                            href = (String) obj3;
                            this.L$0 = $this$withPermit$iv3;
                            this.L$1 = obj3;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                            this.L$3 = href;
                            this.label = 2;
                            redirectLinks = StreamPlayUtilsKt.getRedirectLinks(href, this);
                            if (redirectLinks == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $completion2 = $completion;
                            i = 0;
                            $i$f$withPermit2 = $i$f$withPermit;
                            i2 = 0;
                            href2 = href;
                            obj4 = obj3;
                            $this$withPermit$iv4 = $this$withPermit$iv3;
                            source = (String) redirectLinks;
                            if (source == null) {
                                source = href2;
                            }
                            Function1 function3 = this.$subtitleCallback$inlined;
                            Function1 function4 = this.$callback$inlined;
                            this.L$0 = $this$withPermit$iv4;
                            this.L$1 = obj4;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(href2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(source);
                            this.label = 3;
                            Object obj8 = obj4;
                            $this$withPermit$iv5 = $this$withPermit$iv4;
                            objLoadSourceNameExtractor$default = StreamPlayUtilsKt.loadSourceNameExtractor$default("4Khdhub", source, "", function3, function4, null, null, this, 96, null);
                            if (objLoadSourceNameExtractor$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$withPermit$iv2 = $this$withPermit$iv5;
                            obj2 = objLoadSourceNameExtractor$default;
                            $this$withPermit$iv2.release();
                            return obj2;
                        case 2:
                            String href3 = (String) this.L$3;
                            Continuation $completion3 = (Continuation) this.L$2;
                            Object obj9 = this.L$1;
                            Semaphore $this$withPermit$iv8 = (Semaphore) this.L$0;
                            ResultKt.throwOnFailure($result);
                            redirectLinks = $result;
                            i = 0;
                            $completion2 = $completion3;
                            $i$f$withPermit2 = 0;
                            i2 = 0;
                            href2 = href3;
                            obj4 = obj9;
                            $this$withPermit$iv4 = $this$withPermit$iv8;
                            source = (String) redirectLinks;
                            if (source == null) {
                                source = href2;
                            }
                            Function1 function5 = this.$subtitleCallback$inlined;
                            Function1 function6 = this.$callback$inlined;
                            this.L$0 = $this$withPermit$iv4;
                            this.L$1 = obj4;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(href2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(source);
                            this.label = 3;
                            Object obj10 = obj4;
                            $this$withPermit$iv5 = $this$withPermit$iv4;
                            objLoadSourceNameExtractor$default = StreamPlayUtilsKt.loadSourceNameExtractor$default("4Khdhub", source, "", function5, function6, null, null, this, 96, null);
                            if (objLoadSourceNameExtractor$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$withPermit$iv2 = $this$withPermit$iv5;
                            obj2 = objLoadSourceNameExtractor$default;
                            $this$withPermit$iv2.release();
                            return obj2;
                        case 3:
                            Object obj11 = this.L$1;
                            $this$withPermit$iv2 = (Semaphore) this.L$0;
                            ResultKt.throwOnFailure($result);
                            obj2 = $result;
                            $this$withPermit$iv2.release();
                            return obj2;
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
                    destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C01121(semaphore, item$iv$iv, null, this.$subtitleCallback$inlined, this.$callback$inlined), 2, (Object) null));
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
