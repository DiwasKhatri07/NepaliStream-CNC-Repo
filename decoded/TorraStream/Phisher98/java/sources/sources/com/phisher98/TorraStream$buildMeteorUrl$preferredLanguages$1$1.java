package com.phisher98;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: compiled from: TorraStream.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lorg/json/JSONArray;", "kotlin.jvm.PlatformType", "it", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.TorraStream$buildMeteorUrl$preferredLanguages$1$1", f = "TorraStream.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class TorraStream$buildMeteorUrl$preferredLanguages$1$1 extends SuspendLambda implements Function2<String, Continuation<? super JSONArray>, Object> {
    final /* synthetic */ JSONArray $this_apply;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TorraStream$buildMeteorUrl$preferredLanguages$1$1(JSONArray jSONArray, Continuation<? super TorraStream$buildMeteorUrl$preferredLanguages$1$1> continuation) {
        super(2, continuation);
        this.$this_apply = jSONArray;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> torraStream$buildMeteorUrl$preferredLanguages$1$1 = new TorraStream$buildMeteorUrl$preferredLanguages$1$1(this.$this_apply, continuation);
        torraStream$buildMeteorUrl$preferredLanguages$1$1.L$0 = obj;
        return torraStream$buildMeteorUrl$preferredLanguages$1$1;
    }

    public final Object invoke(String str, Continuation<? super JSONArray> continuation) {
        return create(str, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String it = (String) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                JSONArray jSONArray = this.$this_apply;
                String lowerCase = it.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                return jSONArray.put(lowerCase);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
