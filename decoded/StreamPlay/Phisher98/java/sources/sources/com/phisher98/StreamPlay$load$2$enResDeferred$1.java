package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: StreamPlay.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/phisher98/StreamPlay$MediaDetail;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlay$load$2$enResDeferred$1", f = "StreamPlay.kt", i = {}, l = {383}, m = "invokeSuspend", n = {}, nl = {385}, s = {}, v = 2)
final class StreamPlay$load$2$enResDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super StreamPlay.MediaDetail>, Object> {
    final /* synthetic */ String $enResUrl;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlay$load$2$enResDeferred$1(String str, Continuation<? super StreamPlay$load$2$enResDeferred$1> continuation) {
        super(2, continuation);
        this.$enResUrl = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamPlay$load$2$enResDeferred$1(this.$enResUrl, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super StreamPlay.MediaDetail> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$enResUrl == null) {
                    return null;
                }
                Duration.Companion companion = Duration.Companion;
                this.label = 1;
                obj = TimeoutKt.withTimeoutOrNull-KLykuaI(DurationKt.toDuration(5000, DurationUnit.MILLISECONDS), new C00681(this.$enResUrl, null), (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return (StreamPlay.MediaDetail) obj;
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlay$load$2$enResDeferred$1$1 */
    /* JADX INFO: compiled from: StreamPlay.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/phisher98/StreamPlay$MediaDetail;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlay$load$2$enResDeferred$1$1", f = "StreamPlay.kt", i = {}, l = {384}, m = "invokeSuspend", n = {}, nl = {930}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlay.kt\ncom/phisher98/StreamPlay$load$2$enResDeferred$1$1\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,929:1\n73#2,5:930\n*S KotlinDebug\n*F\n+ 1 StreamPlay.kt\ncom/phisher98/StreamPlay$load$2$enResDeferred$1$1\n*L\n384#1:930,5\n*E\n"})
    static final class C00681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super StreamPlay.MediaDetail>, Object> {
        final /* synthetic */ String $enResUrl;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00681(String str, Continuation<? super C00681> continuation) {
            super(2, continuation);
            this.$enResUrl = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00681(this.$enResUrl, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super StreamPlay.MediaDetail> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object obj;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    obj = Requests.get$default(MainActivityKt.getApp(), this.$enResUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            NiceResponse this_$iv = (NiceResponse) obj;
            try {
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                return parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(StreamPlay.MediaDetail.class));
            } catch (Exception e$iv) {
                e$iv.printStackTrace();
                return null;
            }
        }
    }
}
