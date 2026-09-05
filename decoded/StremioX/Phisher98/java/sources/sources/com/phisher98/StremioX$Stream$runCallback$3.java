package com.phisher98;

import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.SubtitleHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StremioX.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StremioX/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "sub", "Lcom/phisher98/StremioX$Subtitle;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StremioX$Stream$runCallback$3", f = "StremioX.kt", i = {0}, l = {409}, m = "invokeSuspend", n = {"sub"}, nl = {408}, s = {"L$0"}, v = 2)
final class StremioX$Stream$runCallback$3 extends SuspendLambda implements Function2<StremioX.Subtitle, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StremioX$Stream$runCallback$3(Function1<? super SubtitleFile, Unit> function1, Continuation<? super StremioX$Stream$runCallback$3> continuation) {
        super(2, continuation);
        this.$subtitleCallback = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> stremioX$Stream$runCallback$3 = new StremioX$Stream$runCallback$3(this.$subtitleCallback, continuation);
        stremioX$Stream$runCallback$3.L$0 = obj;
        return stremioX$Stream$runCallback$3;
    }

    public final Object invoke(StremioX.Subtitle subtitle, Continuation<? super Unit> continuation) {
        return create(subtitle, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        Object objNewSubtitleFile$default;
        Function1<SubtitleFile, Unit> function1;
        StremioX.Subtitle sub = (StremioX.Subtitle) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function1<SubtitleFile, Unit> function2 = this.$subtitleCallback;
                SubtitleHelper subtitleHelper = SubtitleHelper.INSTANCE;
                String lang = sub.getLang();
                if (lang == null) {
                    lang = "";
                }
                String strFromTagToEnglishLanguageName = subtitleHelper.fromTagToEnglishLanguageName(lang);
                if (strFromTagToEnglishLanguageName != null || (strFromTagToEnglishLanguageName = sub.getLang()) != null) {
                    str = strFromTagToEnglishLanguageName;
                } else {
                    str = "";
                }
                String url = sub.getUrl();
                if (url == null) {
                    return Unit.INSTANCE;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(sub);
                this.L$1 = function2;
                this.label = 1;
                objNewSubtitleFile$default = MainAPIKt.newSubtitleFile$default(str, url, (Function2) null, (Continuation) this, 4, (Object) null);
                if (objNewSubtitleFile$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function1 = function2;
                break;
            case 1:
                function1 = (Function1) this.L$1;
                ResultKt.throwOnFailure($result);
                objNewSubtitleFile$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        function1.invoke(objNewSubtitleFile$default);
        return Unit.INSTANCE;
    }
}
