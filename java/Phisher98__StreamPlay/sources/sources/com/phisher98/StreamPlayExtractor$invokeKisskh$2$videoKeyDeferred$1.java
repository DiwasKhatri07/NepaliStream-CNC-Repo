package com.phisher98;

import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.ResponseParser;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: StreamPlayExtractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeKisskh$2$videoKeyDeferred$1", f = "StreamPlayExtractor.kt", i = {}, l = {427}, m = "invokeSuspend", n = {}, nl = {428}, s = {}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor$invokeKisskh$2$videoKeyDeferred$1\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,6034:1\n73#2,5:6035\n*S KotlinDebug\n*F\n+ 1 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor$invokeKisskh$2$videoKeyDeferred$1\n*L\n428#1:6035,5\n*E\n"})
final class StreamPlayExtractor$invokeKisskh$2$videoKeyDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ int $epsId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlayExtractor$invokeKisskh$2$videoKeyDeferred$1(int i, Continuation<? super StreamPlayExtractor$invokeKisskh$2$videoKeyDeferred$1> continuation) {
        super(2, continuation);
        this.$epsId = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamPlayExtractor$invokeKisskh$2$videoKeyDeferred$1(this.$epsId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object objSafeGet$default;
        Object safe;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    objSafeGet$default = StreamPlayUtilsKt.safeGet$default("https://script.google.com/macros/s/AKfycbzn8B31PuDxzaMa9_CQ0VGEDasFqfzI5bXvjaIZH4DM8DNq9q6xj1ALvZNz_JT3jF0suA/exec?id=" + this.$epsId + "&version=2.8.10", null, null, Boxing.boxLong(10000L), null, false, 0, (Continuation) this, 118, null);
                    if (objSafeGet$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objSafeGet$default = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            NiceResponse this_$iv = (NiceResponse) objSafeGet$default;
            try {
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(KisskhKey.class));
            } catch (Exception e$iv) {
                e$iv.printStackTrace();
                safe = null;
            }
            KisskhKey kisskhKey = (KisskhKey) safe;
            if (kisskhKey != null) {
                return kisskhKey.getKey();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
