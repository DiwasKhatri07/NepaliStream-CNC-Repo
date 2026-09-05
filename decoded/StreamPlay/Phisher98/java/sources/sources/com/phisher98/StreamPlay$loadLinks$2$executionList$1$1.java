package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: StreamPlay.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlay$loadLinks$2$executionList$1$1", f = "StreamPlay.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2}, l = {718, 722, 724}, m = "invokeSuspend", n = {"success", "$this$invokeSuspend_u24lambda_u240", "startTime", "success", "e", "startTime", "success", "e", "$this$invokeSuspend_u24lambda_u241_u240", "startTime"}, nl = {719, 723, 725}, s = {"L$0", "L$1", "J$0", "L$0", "L$8", "J$0", "L$0", "L$3", "L$4", "J$0"}, v = 2)
final class StreamPlay$loadLinks$2$executionList$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $$this$coroutineScope;
    final /* synthetic */ String $authToken;
    final /* synthetic */ Provider $provider;
    final /* synthetic */ AtomicInteger $providersCompleted;
    final /* synthetic */ StreamPlay.LinkData $res;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    final /* synthetic */ int $totalProviders;
    final /* synthetic */ Function1<ExtractorLink, Unit> $wrappedCallback;
    long J$0;
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
    StreamPlay$loadLinks$2$executionList$1$1(CoroutineScope coroutineScope, Provider provider, AtomicInteger atomicInteger, int i, StreamPlay.LinkData linkData, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str, Continuation<? super StreamPlay$loadLinks$2$executionList$1$1> continuation) {
        super(1, continuation);
        this.$$this$coroutineScope = coroutineScope;
        this.$provider = provider;
        this.$providersCompleted = atomicInteger;
        this.$totalProviders = i;
        this.$res = linkData;
        this.$subtitleCallback = function1;
        this.$wrappedCallback = function2;
        this.$authToken = str;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new StreamPlay$loadLinks$2$executionList$1$1(this.$$this$coroutineScope, this.$provider, this.$providersCompleted, this.$totalProviders, this.$res, this.$subtitleCallback, this.$wrappedCallback, this.$authToken, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:32:0x0144 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x0145  */
    /* JADX WARN: Code duplicated, block: B:36:0x017b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x017c  */
    /* JADX WARN: Code duplicated, block: B:48:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:52:0x0210  */
    /* JADX WARN: Code duplicated, block: B:54:0x0214  */
    public final Object invokeSuspend(Object $result) {
        Ref.BooleanRef success;
        long startTime;
        Object obj;
        Object obj2;
        Provider provider;
        CoroutineScope $this$invokeSuspend_u24lambda_u241_u240;
        StreamPlay.LinkData linkData;
        Function1<SubtitleFile, Unit> function1;
        Function1<ExtractorLink, Unit> function2;
        String str;
        Throwable e;
        Throwable e2;
        int i;
        long duration;
        Provider provider2;
        long startTime2;
        Function1<SubtitleFile, Unit> function3;
        Ref.BooleanRef success2;
        String str2;
        StreamPlay.LinkData linkData2;
        Function1<ExtractorLink, Unit> function4;
        long startTime3;
        Provider provider3;
        Function6<StreamPlay.LinkData, Function1<? super SubtitleFile, Unit>, Function1<? super ExtractorLink, Unit>, String, String, Continuation<? super Unit>, Object> invoke;
        Object obj3;
        int completed;
        Throwable retryError;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str3 = "Provider ";
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                long startTime4 = System.currentTimeMillis();
                Ref.BooleanRef success3 = new Ref.BooleanRef();
                CoroutineScope $this$invokeSuspend_u24lambda_u240 = this.$$this$coroutineScope;
                Provider provider4 = this.$provider;
                StreamPlay.LinkData linkData3 = this.$res;
                Function1<SubtitleFile, Unit> function5 = this.$subtitleCallback;
                Function1<ExtractorLink, Unit> function6 = this.$wrappedCallback;
                String str4 = this.$authToken;
                try {
                    Result.Companion companion = Result.Companion;
                    Function6<StreamPlay.LinkData, Function1<? super SubtitleFile, Unit>, Function1<? super ExtractorLink, Unit>, String, String, Continuation<? super Unit>, Object> invoke2 = provider4.getInvoke();
                    this.L$0 = success3;
                    this.L$1 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u240);
                    this.J$0 = startTime4;
                    this.label = 1;
                    if (invoke2.invoke(linkData3, function5, function6, str4, StreamPlay.dahmerMoviesAPI, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    success = success3;
                    startTime = startTime4;
                    success.element = true;
                    obj = Result.constructor-impl(Unit.INSTANCE);
                    obj2 = obj;
                    provider = this.$provider;
                    $this$invokeSuspend_u24lambda_u241_u240 = this.$$this$coroutineScope;
                    linkData = this.$res;
                    function1 = this.$subtitleCallback;
                    function2 = this.$wrappedCallback;
                    str = this.$authToken;
                    e = Result.exceptionOrNull-impl(obj2);
                    if (e != null) {
                        e2 = e;
                        i = 0;
                        Log.INSTANCE.w("StreamPlay", "Provider " + provider.getId() + " failed, retrying: " + e2.getMessage());
                        Duration.Companion companion2 = Duration.Companion;
                        duration = DurationKt.toDuration(2000, DurationUnit.MILLISECONDS);
                        this.L$0 = success;
                        this.L$1 = obj2;
                        this.L$2 = provider;
                        this.L$3 = $this$invokeSuspend_u24lambda_u241_u240;
                        this.L$4 = linkData;
                        this.L$5 = function1;
                        this.L$6 = function2;
                        this.L$7 = str;
                        this.L$8 = SpillingKt.nullOutSpilledVariable(e2);
                        this.J$0 = startTime;
                        this.label = 2;
                        if (DelayKt.delay-VtjQ1oo(duration, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        provider2 = provider;
                        startTime2 = startTime;
                        function3 = function1;
                        success2 = success;
                        str2 = str;
                        linkData2 = linkData;
                        function4 = function2;
                        try {
                            Result.Companion companion3 = Result.Companion;
                            invoke = provider2.getInvoke();
                            this.L$0 = success2;
                            this.L$1 = obj2;
                            this.L$2 = provider2;
                            this.L$3 = SpillingKt.nullOutSpilledVariable(e2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u241_u240);
                            this.L$5 = null;
                            this.L$6 = null;
                            this.L$7 = null;
                            this.L$8 = null;
                            this.J$0 = startTime2;
                            this.label = 3;
                            if (invoke.invoke(linkData2, function3, function4, str2, StreamPlay.dahmerMoviesAPI, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            startTime3 = startTime2;
                            provider3 = provider2;
                            try {
                                success2.element = true;
                                Log.INSTANCE.d("StreamPlay", "✅ Retry succeeded: " + provider3.getId());
                                obj3 = Result.constructor-impl(Unit.INSTANCE);
                            } catch (Throwable th) {
                                th = th;
                                Result.Companion companion4 = Result.Companion;
                                obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            success = success2;
                            retryError = Result.exceptionOrNull-impl(obj3);
                            if (retryError != null) {
                                Log.INSTANCE.e("StreamPlay", str3 + provider3.getId() + " failed after retry: " + retryError.getMessage());
                            }
                            startTime = startTime3;
                        } catch (Throwable th2) {
                            th = th2;
                            startTime3 = startTime2;
                            provider3 = provider2;
                            Result.Companion companion5 = Result.Companion;
                            obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                            success = success2;
                            retryError = Result.exceptionOrNull-impl(obj3);
                            if (retryError != null) {
                                Log.INSTANCE.e("StreamPlay", str3 + provider3.getId() + " failed after retry: " + retryError.getMessage());
                            }
                            startTime = startTime3;
                            long duration2 = System.currentTimeMillis() - startTime;
                            StreamPlayCache.INSTANCE.recordProviderExecution(this.$provider.getId(), success.element, duration2);
                            completed = this.$providersCompleted.incrementAndGet();
                            if (completed % 10 != 0) {
                                Log.INSTANCE.d("StreamPlay", "⏳ Progress: " + completed + '/' + this.$totalProviders + " providers");
                            } else {
                                Log.INSTANCE.d("StreamPlay", "⏳ Progress: " + completed + '/' + this.$totalProviders + " providers");
                            }
                            return Unit.INSTANCE;
                        }
                        break;
                    }
                    long duration3 = System.currentTimeMillis() - startTime;
                    StreamPlayCache.INSTANCE.recordProviderExecution(this.$provider.getId(), success.element, duration3);
                    completed = this.$providersCompleted.incrementAndGet();
                    if (completed % 10 != 0 || completed == this.$totalProviders) {
                        Log.INSTANCE.d("StreamPlay", "⏳ Progress: " + completed + '/' + this.$totalProviders + " providers");
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    success = success3;
                    startTime = startTime4;
                    Result.Companion companion6 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                break;
            case 1:
                startTime = this.J$0;
                success = (Ref.BooleanRef) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    success.element = true;
                    obj = Result.constructor-impl(Unit.INSTANCE);
                    break;
                } catch (Throwable th4) {
                    th = th4;
                    Result.Companion companion7 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                obj2 = obj;
                provider = this.$provider;
                $this$invokeSuspend_u24lambda_u241_u240 = this.$$this$coroutineScope;
                linkData = this.$res;
                function1 = this.$subtitleCallback;
                function2 = this.$wrappedCallback;
                str = this.$authToken;
                e = Result.exceptionOrNull-impl(obj2);
                if (e != null) {
                    e2 = e;
                    i = 0;
                    Log.INSTANCE.w("StreamPlay", "Provider " + provider.getId() + " failed, retrying: " + e2.getMessage());
                    Duration.Companion companion8 = Duration.Companion;
                    duration = DurationKt.toDuration(2000, DurationUnit.MILLISECONDS);
                    this.L$0 = success;
                    this.L$1 = obj2;
                    this.L$2 = provider;
                    this.L$3 = $this$invokeSuspend_u24lambda_u241_u240;
                    this.L$4 = linkData;
                    this.L$5 = function1;
                    this.L$6 = function2;
                    this.L$7 = str;
                    this.L$8 = SpillingKt.nullOutSpilledVariable(e2);
                    this.J$0 = startTime;
                    this.label = 2;
                    if (DelayKt.delay-VtjQ1oo(duration, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    provider2 = provider;
                    startTime2 = startTime;
                    function3 = function1;
                    success2 = success;
                    str2 = str;
                    linkData2 = linkData;
                    function4 = function2;
                    Result.Companion companion9 = Result.Companion;
                    invoke = provider2.getInvoke();
                    this.L$0 = success2;
                    this.L$1 = obj2;
                    this.L$2 = provider2;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(e2);
                    this.L$4 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u241_u240);
                    this.L$5 = null;
                    this.L$6 = null;
                    this.L$7 = null;
                    this.L$8 = null;
                    this.J$0 = startTime2;
                    this.label = 3;
                    if (invoke.invoke(linkData2, function3, function4, str2, StreamPlay.dahmerMoviesAPI, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    startTime3 = startTime2;
                    provider3 = provider2;
                    success2.element = true;
                    Log.INSTANCE.d("StreamPlay", "✅ Retry succeeded: " + provider3.getId());
                    obj3 = Result.constructor-impl(Unit.INSTANCE);
                    success = success2;
                    retryError = Result.exceptionOrNull-impl(obj3);
                    if (retryError != null) {
                        Log.INSTANCE.e("StreamPlay", str3 + provider3.getId() + " failed after retry: " + retryError.getMessage());
                    }
                    startTime = startTime3;
                }
                long duration4 = System.currentTimeMillis() - startTime;
                StreamPlayCache.INSTANCE.recordProviderExecution(this.$provider.getId(), success.element, duration4);
                completed = this.$providersCompleted.incrementAndGet();
                if (completed % 10 != 0) {
                    Log.INSTANCE.d("StreamPlay", "⏳ Progress: " + completed + '/' + this.$totalProviders + " providers");
                } else {
                    Log.INSTANCE.d("StreamPlay", "⏳ Progress: " + completed + '/' + this.$totalProviders + " providers");
                }
                return Unit.INSTANCE;
            case 2:
                long startTime5 = this.J$0;
                Throwable e3 = (Throwable) this.L$8;
                str2 = (String) this.L$7;
                Function1<ExtractorLink, Unit> function7 = (Function1) this.L$6;
                Function1<SubtitleFile, Unit> function8 = (Function1) this.L$5;
                StreamPlay.LinkData linkData4 = (StreamPlay.LinkData) this.L$4;
                $this$invokeSuspend_u24lambda_u241_u240 = (CoroutineScope) this.L$3;
                provider2 = (Provider) this.L$2;
                obj2 = this.L$1;
                Ref.BooleanRef success4 = (Ref.BooleanRef) this.L$0;
                ResultKt.throwOnFailure($result);
                i = 0;
                e2 = e3;
                success2 = success4;
                startTime2 = startTime5;
                function3 = function8;
                function4 = function7;
                linkData2 = linkData4;
                Result.Companion companion10 = Result.Companion;
                invoke = provider2.getInvoke();
                this.L$0 = success2;
                this.L$1 = obj2;
                this.L$2 = provider2;
                this.L$3 = SpillingKt.nullOutSpilledVariable(e2);
                this.L$4 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u241_u240);
                this.L$5 = null;
                this.L$6 = null;
                this.L$7 = null;
                this.L$8 = null;
                this.J$0 = startTime2;
                this.label = 3;
                if (invoke.invoke(linkData2, function3, function4, str2, StreamPlay.dahmerMoviesAPI, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                startTime3 = startTime2;
                provider3 = provider2;
                success2.element = true;
                Log.INSTANCE.d("StreamPlay", "✅ Retry succeeded: " + provider3.getId());
                obj3 = Result.constructor-impl(Unit.INSTANCE);
                success = success2;
                retryError = Result.exceptionOrNull-impl(obj3);
                if (retryError != null) {
                    Log.INSTANCE.e("StreamPlay", str3 + provider3.getId() + " failed after retry: " + retryError.getMessage());
                }
                startTime = startTime3;
                long duration5 = System.currentTimeMillis() - startTime;
                StreamPlayCache.INSTANCE.recordProviderExecution(this.$provider.getId(), success.element, duration5);
                completed = this.$providersCompleted.incrementAndGet();
                if (completed % 10 != 0) {
                    Log.INSTANCE.d("StreamPlay", "⏳ Progress: " + completed + '/' + this.$totalProviders + " providers");
                } else {
                    Log.INSTANCE.d("StreamPlay", "⏳ Progress: " + completed + '/' + this.$totalProviders + " providers");
                }
                return Unit.INSTANCE;
            case 3:
                startTime3 = this.J$0;
                provider3 = (Provider) this.L$2;
                success2 = (Ref.BooleanRef) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    str3 = "Provider ";
                    success2.element = true;
                    Log.INSTANCE.d("StreamPlay", "✅ Retry succeeded: " + provider3.getId());
                    obj3 = Result.constructor-impl(Unit.INSTANCE);
                    break;
                } catch (Throwable th5) {
                    th = th5;
                    str3 = "Provider ";
                    Result.Companion companion11 = Result.Companion;
                    obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                    success = success2;
                    retryError = Result.exceptionOrNull-impl(obj3);
                    if (retryError != null) {
                        Log.INSTANCE.e("StreamPlay", str3 + provider3.getId() + " failed after retry: " + retryError.getMessage());
                    }
                    startTime = startTime3;
                    long duration6 = System.currentTimeMillis() - startTime;
                    StreamPlayCache.INSTANCE.recordProviderExecution(this.$provider.getId(), success.element, duration6);
                    completed = this.$providersCompleted.incrementAndGet();
                    if (completed % 10 != 0) {
                        Log.INSTANCE.d("StreamPlay", "⏳ Progress: " + completed + '/' + this.$totalProviders + " providers");
                    } else {
                        Log.INSTANCE.d("StreamPlay", "⏳ Progress: " + completed + '/' + this.$totalProviders + " providers");
                    }
                    return Unit.INSTANCE;
                }
                success = success2;
                retryError = Result.exceptionOrNull-impl(obj3);
                if (retryError != null) {
                    Log.INSTANCE.e("StreamPlay", str3 + provider3.getId() + " failed after retry: " + retryError.getMessage());
                }
                startTime = startTime3;
                long duration7 = System.currentTimeMillis() - startTime;
                StreamPlayCache.INSTANCE.recordProviderExecution(this.$provider.getId(), success.element, duration7);
                completed = this.$providersCompleted.incrementAndGet();
                if (completed % 10 != 0) {
                    Log.INSTANCE.d("StreamPlay", "⏳ Progress: " + completed + '/' + this.$totalProviders + " providers");
                } else {
                    Log.INSTANCE.d("StreamPlay", "⏳ Progress: " + completed + '/' + this.$totalProviders + " providers");
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
