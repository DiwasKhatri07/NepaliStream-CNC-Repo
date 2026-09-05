package com.phisher98;

import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.ResponseParser;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: StreamPlayExtractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/phisher98/KisskhSources;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeKisskh$3$sourcesDeferred$1", f = "StreamPlayExtractor.kt", i = {}, l = {451}, m = "invokeSuspend", n = {}, nl = {454}, s = {}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor$invokeKisskh$3$sourcesDeferred$1\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,6034:1\n73#2,5:6035\n*S KotlinDebug\n*F\n+ 1 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor$invokeKisskh$3$sourcesDeferred$1\n*L\n454#1:6035,5\n*E\n"})
final class StreamPlayExtractor$invokeKisskh$3$sourcesDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super KisskhSources>, Object> {
    final /* synthetic */ String $contentTitle;
    final /* synthetic */ Integer $episode;
    final /* synthetic */ int $epsId;
    final /* synthetic */ Integer $id;
    final /* synthetic */ String $kkey;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlayExtractor$invokeKisskh$3$sourcesDeferred$1(int i, String str, String str2, Integer num, Integer num2, Continuation<? super StreamPlayExtractor$invokeKisskh$3$sourcesDeferred$1> continuation) {
        super(2, continuation);
        this.$epsId = i;
        this.$kkey = str;
        this.$contentTitle = str2;
        this.$episode = num;
        this.$id = num2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamPlayExtractor$invokeKisskh$3$sourcesDeferred$1(this.$epsId, this.$kkey, this.$contentTitle, this.$episode, this.$id, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super KisskhSources> continuation) {
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
                    String str = "https://kisskh.nl/api/DramaList/Episode/" + this.$epsId + ".png?err=false&ts=&time=&kkey=" + this.$kkey;
                    StringBuilder sbAppend = new StringBuilder().append("https://kisskh.nl/Drama/").append(StreamPlayUtilsKt.getKisskhTitle(this.$contentTitle)).append("/Episode-");
                    Integer num = this.$episode;
                    int iIntValue = num != null ? num.intValue() : 0;
                    this.label = 1;
                    objSafeGet$default = StreamPlayUtilsKt.safeGet$default(str, null, sbAppend.append(iIntValue).append("?id=").append(this.$id.intValue()).append("&ep=").append(this.$epsId).append("&page=0&pageSize=100").toString(), null, null, false, 0, (Continuation) this, 122, null);
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
                safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(KisskhSources.class));
            } catch (Exception e$iv) {
                e$iv.printStackTrace();
                safe = null;
            }
            return (KisskhSources) safe;
        } catch (Exception e) {
            return null;
        }
    }
}
