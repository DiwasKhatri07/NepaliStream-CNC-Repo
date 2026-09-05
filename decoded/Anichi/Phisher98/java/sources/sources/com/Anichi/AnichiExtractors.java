package com.Anichi;

import androidx.appcompat.app.AppCompatActivity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnichiExtractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Anichi/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0007JN\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0\u000eH\u0086@¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002¨\u0006\u0015"}, d2 = {"Lcom/Anichi/AnichiExtractors;", "Lcom/Anichi/Anichi;", "<init>", "()V", "showTurnstileDialogAndWait", "", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeInternalSources", "", "hash", "dubStatus", "episode", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decrypthex", "inputStr", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class AnichiExtractors extends Anichi {

    @NotNull
    public static final AnichiExtractors INSTANCE = new AnichiExtractors();

    private AnichiExtractors() {
    }

    /* JADX INFO: renamed from: com.Anichi.AnichiExtractors$showTurnstileDialogAndWait$2 */
    /* JADX INFO: compiled from: AnichiExtractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.AnichiExtractors$showTurnstileDialogAndWait$2", f = "AnichiExtractors.kt", i = {0}, l = {985}, m = "invokeSuspend", n = {"$this$withContext"}, nl = {985}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nAnichiExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnichiExtractors.kt\ncom/Anichi/AnichiExtractors$showTurnstileDialogAndWait$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,984:1\n433#2,10:985\n*S KotlinDebug\n*F\n+ 1 AnichiExtractors.kt\ncom/Anichi/AnichiExtractors$showTurnstileDialogAndWait$2\n*L\n63#1:985,10\n*E\n"})
    static final class C00142 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00142(String str, Continuation<? super C00142> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00142 = new C00142(this.$url, continuation);
            c00142.L$0 = obj;
            return c00142;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            final CoroutineScope $this$withContext = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str = this.$url;
                    this.L$0 = $this$withContext;
                    this.L$1 = str;
                    this.label = 1;
                    Continuation uCont$iv = (Continuation) this;
                    Continuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                    cancellableContinuationImpl.initCancellability();
                    final Continuation continuation = (CancellableContinuation) cancellableContinuationImpl;
                    AppCompatActivity activity = CommonActivity.INSTANCE.getActivity();
                    final AppCompatActivity activity2 = activity instanceof AppCompatActivity ? activity : null;
                    if (activity2 == null || activity2.isFinishing() || activity2.isDestroyed()) {
                        Result.Companion companion = Result.Companion;
                        continuation.resumeWith(Result.constructor-impl((Object) null));
                    } else {
                        final Ref.BooleanRef resumed = new Ref.BooleanRef();
                        final AnichiTurnstileDialog dialog = new AnichiTurnstileDialog(str, new Function1<String, Unit>() { // from class: com.Anichi.AnichiExtractors$showTurnstileDialogAndWait$2$1$dialog$1
                            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                invoke((String) p1);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(String responseBody) {
                                AnichiExtractors.C00142.invokeSuspend$lambda$0$safeResume(resumed, continuation, responseBody);
                            }
                        });
                        continuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.Anichi.AnichiExtractors$showTurnstileDialogAndWait$2$1$1
                            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                invoke((Throwable) p1);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Throwable it) {
                                AppCompatActivity appCompatActivity = activity2;
                                final CoroutineScope coroutineScope = $this$withContext;
                                final AnichiTurnstileDialog anichiTurnstileDialog = dialog;
                                appCompatActivity.runOnUiThread(new Runnable() { // from class: com.Anichi.AnichiExtractors$showTurnstileDialogAndWait$2$1$1.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        CoroutineScope coroutineScope2 = coroutineScope;
                                        AnichiTurnstileDialog anichiTurnstileDialog2 = anichiTurnstileDialog;
                                        try {
                                            Result.Companion companion2 = Result.Companion;
                                            anichiTurnstileDialog2.dismissAllowingStateLoss();
                                            Result.constructor-impl(Unit.INSTANCE);
                                        } catch (Throwable th) {
                                            Result.Companion companion3 = Result.Companion;
                                            Result.constructor-impl(ResultKt.createFailure(th));
                                        }
                                    }
                                });
                            }
                        });
                        dialog.show(activity2.getSupportFragmentManager(), "anichi_turnstile");
                    }
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended((Continuation) this);
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return result;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0$safeResume(Ref.BooleanRef resumed, CancellableContinuation<? super String> cancellableContinuation, String responseBody) {
            if (!resumed.element) {
                resumed.element = true;
                Result.Companion companion = Result.Companion;
                ((Continuation) cancellableContinuation).resumeWith(Result.constructor-impl(responseBody));
            }
        }
    }

    @Nullable
    public final Object showTurnstileDialogAndWait(@NotNull String url, @NotNull Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new C00142(url, null), continuation);
    }

    /* JADX INFO: renamed from: com.Anichi.AnichiExtractors$invokeInternalSources$2 */
    /* JADX INFO: compiled from: AnichiExtractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.AnichiExtractors$invokeInternalSources$2", f = "AnichiExtractors.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7}, l = {93, 99, 106, 113, 114, 130, 142, 148}, m = "invokeSuspend", n = {"$this$coroutineScope", "responseText", "lane", "$this$coroutineScope", "responseText", "lane", "aaReq", "fullApiUrl", "$this$coroutineScope", "responseText", "lane", "aaReq", "fullApiUrl", "fallbackQuery", "postBody", "$this$coroutineScope", "responseText", "lane", "aaReq", "fullApiUrl", "delaySec", "$this$coroutineScope", "responseText", "lane", "aaReq", "fullApiUrl", "delaySec", "$this$coroutineScope", "responseText", "lane", "aaReq", "episodePageUrl", "needsCaptcha", "$this$coroutineScope", "responseText", "lane", "aaReq", "encryptedData", "encrypted", "it", "needsCaptcha", "$this$coroutineScope", "responseText", "lane", "aaReq", "encryptedData", "encrypted", "finalJson", "needsCaptcha"}, nl = {95, 100, 107, 114, 118, 131, 142, 151}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nAnichiExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnichiExtractors.kt\ncom/Anichi/AnichiExtractors$invokeInternalSources$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,984:1\n93#2,2:985\n63#2:987\n64#2,15:989\n95#2,2:1006\n93#2,2:1009\n63#2:1011\n64#2,15:1013\n95#2,2:1030\n1#3:988\n1#3:1008\n1#3:1012\n50#4:1004\n43#4:1005\n50#4:1028\n43#4:1029\n2068#5,2:1032\n*S KotlinDebug\n*F\n+ 1 AnichiExtractors.kt\ncom/Anichi/AnichiExtractors$invokeInternalSources$2\n*L\n139#1:985,2\n139#1:987\n139#1:989,15\n139#1:1006,2\n154#1:1009,2\n154#1:1011\n154#1:1013,15\n154#1:1030,2\n139#1:988\n154#1:1012\n139#1:1004\n139#1:1005\n154#1:1028\n154#1:1029\n162#1:1032,2\n*E\n"})
    static final class C00102 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ String $episode;
        final /* synthetic */ String $hash;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int I$0;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00102(String str, String str2, String str3, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00102> continuation) {
            super(2, continuation);
            this.$hash = str;
            this.$dubStatus = str2;
            this.$episode = str3;
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00102 = new C00102(this.$hash, this.$dubStatus, this.$episode, this.$subtitleCallback, this.$callback, continuation);
            c00102.L$0 = obj;
            return c00102;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:105:0x03ea  */
        /* JADX WARN: Code duplicated, block: B:106:0x03f0  */
        /* JADX WARN: Code duplicated, block: B:108:0x03f9  */
        /* JADX WARN: Code duplicated, block: B:118:0x0437  */
        /* JADX WARN: Code duplicated, block: B:121:0x043b  */
        /* JADX WARN: Code duplicated, block: B:123:0x049d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:126:0x04a2  */
        /* JADX WARN: Code duplicated, block: B:128:0x04a5  */
        /* JADX WARN: Code duplicated, block: B:129:0x04a9  */
        /* JADX WARN: Code duplicated, block: B:134:0x04b5  */
        /* JADX WARN: Code duplicated, block: B:135:0x04ba  */
        /* JADX WARN: Code duplicated, block: B:142:0x04e6  */
        /* JADX WARN: Code duplicated, block: B:154:0x0522  */
        /* JADX WARN: Code duplicated, block: B:155:0x0524  */
        /* JADX WARN: Code duplicated, block: B:164:0x0540 A[Catch: Exception -> 0x055b, TRY_LEAVE, TryCatch #6 {Exception -> 0x055b, blocks: (B:152:0x051c, B:156:0x0525, B:164:0x0540, B:163:0x053a, B:151:0x0512, B:158:0x052b), top: B:297:0x0512, inners: #34 }] */
        /* JADX WARN: Code duplicated, block: B:176:0x056d  */
        /* JADX WARN: Code duplicated, block: B:178:0x0570 A[Catch: Exception -> 0x060e, TryCatch #17 {Exception -> 0x060e, blocks: (B:192:0x05c4, B:175:0x0568, B:178:0x0570, B:181:0x0578), top: B:311:0x0568 }] */
        /* JADX WARN: Code duplicated, block: B:179:0x0575  */
        /* JADX WARN: Code duplicated, block: B:181:0x0578 A[Catch: Exception -> 0x060e, TRY_LEAVE, TryCatch #17 {Exception -> 0x060e, blocks: (B:192:0x05c4, B:175:0x0568, B:178:0x0570, B:181:0x0578), top: B:311:0x0568 }] */
        /* JADX WARN: Code duplicated, block: B:183:0x05a3 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:184:0x05a4  */
        /* JADX WARN: Code duplicated, block: B:189:0x05be  */
        /* JADX WARN: Code duplicated, block: B:191:0x05c2 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:202:0x0618  */
        /* JADX WARN: Code duplicated, block: B:203:0x061a  */
        /* JADX WARN: Code duplicated, block: B:208:0x062b  */
        /* JADX WARN: Code duplicated, block: B:209:0x0634  */
        /* JADX WARN: Code duplicated, block: B:216:0x0660  */
        /* JADX WARN: Code duplicated, block: B:232:0x06ad  */
        /* JADX WARN: Code duplicated, block: B:242:0x06c9 A[Catch: Exception -> 0x06e3, TRY_LEAVE, TryCatch #12 {Exception -> 0x06e3, blocks: (B:230:0x06a7, B:233:0x06ae, B:242:0x06c9, B:241:0x06c3, B:229:0x069d, B:236:0x06b4), top: B:306:0x069d, inners: #13, #33 }] */
        /* JADX WARN: Code duplicated, block: B:253:0x06f2 A[Catch: Exception -> 0x071a, TryCatch #8 {Exception -> 0x071a, blocks: (B:251:0x06ee, B:253:0x06f2, B:255:0x06f9, B:257:0x06ff, B:261:0x0708, B:263:0x070e), top: B:300:0x06ee }] */
        /* JADX WARN: Code duplicated, block: B:255:0x06f9 A[Catch: Exception -> 0x071a, TryCatch #8 {Exception -> 0x071a, blocks: (B:251:0x06ee, B:253:0x06f2, B:255:0x06f9, B:257:0x06ff, B:261:0x0708, B:263:0x070e), top: B:300:0x06ee }] */
        /* JADX WARN: Code duplicated, block: B:261:0x0708 A[Catch: Exception -> 0x071a, TryCatch #8 {Exception -> 0x071a, blocks: (B:251:0x06ee, B:253:0x06f2, B:255:0x06f9, B:257:0x06ff, B:261:0x0708, B:263:0x070e), top: B:300:0x06ee }] */
        /* JADX WARN: Code duplicated, block: B:263:0x070e A[Catch: Exception -> 0x071a, TRY_LEAVE, TryCatch #8 {Exception -> 0x071a, blocks: (B:251:0x06ee, B:253:0x06f2, B:255:0x06f9, B:257:0x06ff, B:261:0x0708, B:263:0x070e), top: B:300:0x06ee }] */
        /* JADX WARN: Code duplicated, block: B:265:0x0713  */
        /* JADX WARN: Code duplicated, block: B:267:0x0715  */
        /* JADX WARN: Code duplicated, block: B:279:0x073c  */
        /* JADX WARN: Code duplicated, block: B:281:0x073f  */
        /* JADX WARN: Code duplicated, block: B:284:0x0753 A[LOOP:0: B:282:0x074d->B:284:0x0753, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:311:0x0568 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:323:0x04eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:331:0x0668 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:343:0x052b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:345:0x06b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:40:0x017e  */
        /* JADX WARN: Code duplicated, block: B:45:0x01fe A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:46:0x01ff  */
        /* JADX WARN: Code duplicated, block: B:58:0x022e  */
        /* JADX WARN: Code duplicated, block: B:63:0x02ea A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:64:0x02eb  */
        /* JADX WARN: Code duplicated, block: B:75:0x0314  */
        /* JADX WARN: Code duplicated, block: B:78:0x0326  */
        /* JADX WARN: Code duplicated, block: B:80:0x0337  */
        /* JADX WARN: Code duplicated, block: B:87:0x0351  */
        /* JADX WARN: Code duplicated, block: B:91:0x0388 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:92:0x0389  */
        /* JADX WARN: Code duplicated, block: B:95:0x03d5 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:96:0x03d6  */
        public final Object invokeSuspend(Object $result) {
            String responseText;
            Object objGenerateAaReq;
            String responseText2;
            String aaReq;
            Object obj;
            String finalJson;
            String lane;
            String responseText3;
            String fullApiUrl;
            String lane2;
            String lane3;
            Object obj2;
            String text;
            String responseText4;
            String str;
            String fullApiUrl2;
            String aaReq2;
            String fullApiUrl3;
            String fallbackQuery;
            String fullApiUrl4;
            Object objPost$default;
            String text2;
            MatchResult matchResultFind$default;
            long delaySec;
            long delaySec2;
            String aaReq3;
            String lane4;
            String fullApiUrl5;
            List groupValues;
            Long longOrNull;
            Object obj3;
            String text3;
            int i;
            int i2;
            int i3;
            Object objShowTurnstileDialogAndWait;
            CoroutineScope $this$coroutineScope;
            String value$iv;
            Object obj4;
            String aaReq4;
            Object obj5;
            Object obj6;
            DeserializationStrategy deserializationStrategy;
            Object objDecodeFromString;
            EncryptedResponse encryptedResponse;
            EncryptedData encryptedData;
            String encrypted;
            EncryptedData encryptedData2;
            String aaReq5;
            Object objDecodeToBeParsed;
            String lane5;
            Object obj7;
            String lane6;
            String interceptedResponse;
            String encrypted2;
            Object objDecodeToBeParsed2;
            ArrayList<AnichiParser.SourceUrls> sourceUrls;
            Function1<SubtitleFile, Unit> function1;
            Function1<ExtractorLink, Unit> function2;
            String str2;
            String str3;
            String jsonToParse;
            Object obj8;
            int i4;
            Object objDecodeFromString2;
            CoroutineScope $this$coroutineScope2;
            DeserializationStrategy deserializationStrategy2;
            AnichiParser.LinksQuery it;
            AnichiParser.LinkData data;
            AnichiParser.Episode episode;
            AnichiParser.Episode episode2;
            ArrayList<AnichiParser.SourceUrls> sourceUrls2;
            CoroutineScope $this$coroutineScope3 = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    responseText = "k7";
                    this.L$0 = $this$coroutineScope3;
                    this.L$1 = "";
                    this.L$2 = "k7";
                    this.label = 1;
                    objGenerateAaReq = AnichiUtilsKt.generateAaReq(Anichi.serverHash, "k7", (Continuation) this);
                    if (objGenerateAaReq == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    responseText2 = "";
                    aaReq = (String) objGenerateAaReq;
                    if (aaReq != null) {
                        fullApiUrl = "https://api.allanime.day/api?variables={\"showId\":\"" + this.$hash + "\",\"translationType\":\"" + this.$dubStatus + "\",\"episodeString\":\"" + this.$episode + "\"}&extensions={\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"d405d0edd690624b66baba3068e0edc3ac90f1597d898a1ec8db4e5c43c00fec\"},\"k\":\"" + responseText + "\",\"aaReq\":\"" + aaReq + "\"}";
                        try {
                            Requests app = MainActivityKt.getApp();
                            Map<String, String> headers = Anichi.INSTANCE.getHeaders();
                            Continuation continuation = (Continuation) this;
                            this.L$0 = $this$coroutineScope3;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(responseText2);
                            this.L$2 = responseText;
                            this.L$3 = aaReq;
                            this.L$4 = fullApiUrl;
                            this.label = 2;
                            try {
                                obj2 = Requests.get$default(app, fullApiUrl, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, continuation, 4092, (Object) null);
                                if (obj2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                lane2 = responseText;
                                lane3 = fullApiUrl;
                                try {
                                    text = ((NiceResponse) obj2).getText();
                                } catch (Exception e) {
                                    text = "";
                                }
                                responseText4 = text;
                                obj = "kotlinx.serialization.serializer.simple";
                                str = "";
                                if (StringsKt.contains$default(responseText4, "PERSISTED_QUERY_NOT_FOUND", false, 2, (Object) null)) {
                                    String postBody = "{\"query\":\"query($showId: String!, $translationType: VaildTranslationTypeEnumType!, $episodeString: String!) { episode(showId: $showId, translationType: $translationType, episodeString: $episodeString) { episodeString uploadDate sourceUrls thumbnail notes show { _id type englishName name nativeName nameOnlyString altNames slugTime description availableEpisodes episodeCount lastEpisodeInfo episodeDuration airedStart score thumbnail banner genres isAdult } } }\",\"variables\":{\"showId\":\"" + this.$hash + "\",\"translationType\":\"" + this.$dubStatus + "\",\"episodeString\":\"" + this.$episode + "\"},\"extensions\":{\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"d405d0edd690624b66baba3068e0edc3ac90f1597d898a1ec8db4e5c43c00fec\"},\"k\":\"" + lane2 + "\",\"aaReq\":\"" + aaReq + "\"}}";
                                    try {
                                        Requests app2 = MainActivityKt.getApp();
                                        Map mapPlus = MapsKt.plus(Anichi.INSTANCE.getHeaders(), MapsKt.mapOf(TuplesKt.to("Content-Type", "application/json")));
                                        RequestBody requestBodyCreate = RequestBody.Companion.create(postBody, MediaType.Companion.parse("application/json"));
                                        Continuation continuation2 = (Continuation) this;
                                        this.L$0 = $this$coroutineScope3;
                                        try {
                                            this.L$1 = responseText4;
                                            this.L$2 = SpillingKt.nullOutSpilledVariable(lane2);
                                            this.L$3 = aaReq;
                                            this.L$4 = lane3;
                                            this.L$5 = SpillingKt.nullOutSpilledVariable("query($showId: String!, $translationType: VaildTranslationTypeEnumType!, $episodeString: String!) { episode(showId: $showId, translationType: $translationType, episodeString: $episodeString) { episodeString uploadDate sourceUrls thumbnail notes show { _id type englishName name nativeName nameOnlyString altNames slugTime description availableEpisodes episodeCount lastEpisodeInfo episodeDuration airedStart score thumbnail banner genres isAdult } } }");
                                            this.L$6 = SpillingKt.nullOutSpilledVariable(postBody);
                                            this.label = 3;
                                            objPost$default = Requests.post$default(app2, Anichi.apiUrl, mapPlus, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, continuation2, 65276, (Object) null);
                                            if (objPost$default == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            aaReq2 = aaReq;
                                            fullApiUrl3 = lane3;
                                            fallbackQuery = responseText4;
                                            fullApiUrl4 = lane2;
                                            try {
                                                text2 = ((NiceResponse) objPost$default).getText();
                                                aaReq = aaReq2;
                                                lane2 = fullApiUrl4;
                                            } catch (Exception e2) {
                                                text2 = fallbackQuery;
                                                aaReq = aaReq2;
                                                lane2 = fullApiUrl4;
                                            }
                                            responseText4 = text2;
                                            fullApiUrl2 = fullApiUrl3;
                                        } catch (Exception e3) {
                                            aaReq2 = aaReq;
                                            fullApiUrl3 = lane3;
                                            fallbackQuery = responseText4;
                                            fullApiUrl4 = lane2;
                                            text2 = fallbackQuery;
                                            aaReq = aaReq2;
                                            lane2 = fullApiUrl4;
                                            responseText4 = text2;
                                            fullApiUrl2 = fullApiUrl3;
                                            if (StringsKt.contains$default(responseText4, "Too many requests, please try again in", false, 2, (Object) null)) {
                                                matchResultFind$default = Regex.find$default(new Regex("try again in (\\d+)"), responseText4, 0, 2, (Object) null);
                                                delaySec = matchResultFind$default == null ? 2L : 2L;
                                                Duration.Companion companion = Duration.Companion;
                                                this.L$0 = $this$coroutineScope3;
                                                this.L$1 = SpillingKt.nullOutSpilledVariable(responseText4);
                                                this.L$2 = SpillingKt.nullOutSpilledVariable(lane2);
                                                this.L$3 = aaReq;
                                                this.L$4 = fullApiUrl2;
                                                this.L$5 = null;
                                                this.L$6 = null;
                                                this.J$0 = delaySec;
                                                this.label = 4;
                                                if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration((1000 * delaySec) + 500, DurationUnit.MILLISECONDS), (Continuation) this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                delaySec2 = delaySec;
                                                aaReq3 = aaReq;
                                                lane4 = lane2;
                                                fullApiUrl5 = fullApiUrl2;
                                                try {
                                                    this.L$0 = $this$coroutineScope3;
                                                    this.L$1 = SpillingKt.nullOutSpilledVariable(responseText4);
                                                    this.L$2 = SpillingKt.nullOutSpilledVariable(lane4);
                                                    this.L$3 = aaReq3;
                                                    this.L$4 = SpillingKt.nullOutSpilledVariable(fullApiUrl5);
                                                    this.J$0 = delaySec2;
                                                    this.label = 5;
                                                    obj3 = Requests.get$default(MainActivityKt.getApp(), fullApiUrl5, Anichi.INSTANCE.getHeaders(), (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4092, (Object) null);
                                                    if (obj3 == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    try {
                                                        text3 = ((NiceResponse) obj3).getText();
                                                    } catch (Exception e4) {
                                                        text3 = str;
                                                    }
                                                    responseText3 = text3;
                                                    finalJson = aaReq3;
                                                    lane = lane4;
                                                } catch (Exception e5) {
                                                    text3 = str;
                                                    responseText3 = text3;
                                                    finalJson = aaReq3;
                                                    lane = lane4;
                                                    if (finalJson != null) {
                                                        i = 1;
                                                    } else {
                                                        i = 1;
                                                    }
                                                    i2 = i;
                                                    if (i2 != 0) {
                                                        Log.INSTANCE.d("Anichi", "NEED_CAPTCHA – opening episode WebView to intercept API response…");
                                                        String episodePageUrl = "https://mkissa.to/bangumi/" + this.$hash + "/p-" + this.$episode + '-' + this.$dubStatus;
                                                        this.L$0 = $this$coroutineScope3;
                                                        this.L$1 = SpillingKt.nullOutSpilledVariable(responseText3);
                                                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                                                        this.L$3 = SpillingKt.nullOutSpilledVariable(finalJson);
                                                        this.L$4 = SpillingKt.nullOutSpilledVariable(episodePageUrl);
                                                        this.L$5 = null;
                                                        this.L$6 = null;
                                                        this.I$0 = i2;
                                                        this.label = 6;
                                                        objShowTurnstileDialogAndWait = AnichiExtractors.INSTANCE.showTurnstileDialogAndWait(episodePageUrl, (Continuation) this);
                                                        if (objShowTurnstileDialogAndWait == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        interceptedResponse = (String) objShowTurnstileDialogAndWait;
                                                        if (interceptedResponse == null) {
                                                            return Unit.INSTANCE;
                                                        }
                                                        i3 = i2;
                                                        responseText3 = interceptedResponse;
                                                    } else {
                                                        i3 = i2;
                                                    }
                                                    AppUtils appUtils = AppUtils.INSTANCE;
                                                    value$iv = responseText3;
                                                    if (value$iv == null) {
                                                        try {
                                                            try {
                                                                Result.Companion companion2 = Result.Companion;
                                                                KType kTypeTypeOf = Reflection.typeOf(EncryptedResponse.class);
                                                                MagicApiIntrinsics.voidMagicApiCall(obj);
                                                                obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                                            } catch (Exception e6) {
                                                                aaReq4 = finalJson;
                                                                obj5 = null;
                                                                encryptedResponse = (EncryptedResponse) obj5;
                                                                if (encryptedResponse != null) {
                                                                    try {
                                                                        encryptedData = encryptedResponse.getData();
                                                                    } catch (Exception e7) {
                                                                        e = e7;
                                                                        $this$coroutineScope = $this$coroutineScope3;
                                                                        finalJson = aaReq4;
                                                                        e.printStackTrace();
                                                                        sourceUrls = null;
                                                                        if (sourceUrls == null) {
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                        ArrayList<AnichiParser.SourceUrls> $this$forEach$iv = sourceUrls;
                                                                        function1 = this.$subtitleCallback;
                                                                        function2 = this.$callback;
                                                                        str2 = this.$dubStatus;
                                                                        for (Object element$iv : $this$forEach$iv) {
                                                                            AnichiParser.SourceUrls source = (AnichiParser.SourceUrls) element$iv;
                                                                            BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source, function1, function2, str2, null), 3, (Object) null);
                                                                            function1 = function1;
                                                                            function2 = function2;
                                                                            str2 = str2;
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                } else {
                                                                    encryptedData = null;
                                                                }
                                                                if (encryptedData != null) {
                                                                    encrypted = encryptedData.getTobeparsed();
                                                                } else {
                                                                    encrypted = null;
                                                                }
                                                                if (encrypted != null) {
                                                                    String it2 = encrypted;
                                                                    String _mVar = encryptedData.get_m();
                                                                    this.L$0 = $this$coroutineScope3;
                                                                    this.L$1 = responseText3;
                                                                    this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                                                                    this.L$3 = SpillingKt.nullOutSpilledVariable(aaReq4);
                                                                    this.L$4 = encryptedData;
                                                                    this.L$5 = encrypted;
                                                                    this.L$6 = SpillingKt.nullOutSpilledVariable(it2);
                                                                    this.I$0 = i3;
                                                                    this.label = 7;
                                                                    objDecodeToBeParsed = AnichiUtilsKt.decodeToBeParsed(it2, _mVar, this);
                                                                    if (objDecodeToBeParsed == coroutine_suspended) {
                                                                        return coroutine_suspended;
                                                                    }
                                                                    String str4 = lane;
                                                                    lane5 = encrypted;
                                                                    obj7 = objDecodeToBeParsed;
                                                                    lane6 = str4;
                                                                    encryptedData2 = encryptedData;
                                                                    try {
                                                                        encrypted = lane5;
                                                                        aaReq5 = (String) obj7;
                                                                        lane = lane6;
                                                                    } catch (Exception e8) {
                                                                        e = e8;
                                                                        $this$coroutineScope = $this$coroutineScope3;
                                                                        lane = lane6;
                                                                        finalJson = aaReq4;
                                                                        e.printStackTrace();
                                                                        sourceUrls = null;
                                                                        if (sourceUrls == null) {
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                        ArrayList<AnichiParser.SourceUrls> $this$forEach$iv2 = sourceUrls;
                                                                        function1 = this.$subtitleCallback;
                                                                        function2 = this.$callback;
                                                                        str2 = this.$dubStatus;
                                                                        while (r12.hasNext()) {
                                                                            AnichiParser.SourceUrls source2 = (AnichiParser.SourceUrls) element$iv;
                                                                            BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source2, function1, function2, str2, null), 3, (Object) null);
                                                                            function1 = function1;
                                                                            function2 = function2;
                                                                            str2 = str2;
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                } else {
                                                                    encryptedData2 = encryptedData;
                                                                    aaReq5 = null;
                                                                }
                                                                if (aaReq5 == null) {
                                                                }
                                                                encrypted2 = encrypted;
                                                                if (aaReq5 == null) {
                                                                    str3 = responseText3;
                                                                } else {
                                                                    str3 = aaReq5;
                                                                }
                                                                jsonToParse = str3;
                                                                Log.INSTANCE.d("Phisher", jsonToParse);
                                                                AppUtils appUtils2 = AppUtils.INSTANCE;
                                                                if (jsonToParse == null) {
                                                                    try {
                                                                        try {
                                                                            Result.Companion companion3 = Result.Companion;
                                                                            KType kTypeTypeOf2 = Reflection.typeOf(AnichiParser.LinksQuery.class);
                                                                            MagicApiIntrinsics.voidMagicApiCall(obj);
                                                                            obj8 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                                                        } catch (Exception e9) {
                                                                            i4 = i3;
                                                                            $this$coroutineScope = $this$coroutineScope3;
                                                                            objDecodeFromString2 = null;
                                                                            it = (AnichiParser.LinksQuery) objDecodeFromString2;
                                                                            if (it != null) {
                                                                                data = it.getData();
                                                                                if (data != null) {
                                                                                    episode = it.getEpisode();
                                                                                    if (episode != null) {
                                                                                        sourceUrls = episode.getSourceUrls();
                                                                                    } else {
                                                                                        sourceUrls = null;
                                                                                    }
                                                                                } else {
                                                                                    episode = it.getEpisode();
                                                                                    if (episode != null) {
                                                                                        sourceUrls = episode.getSourceUrls();
                                                                                    } else {
                                                                                        sourceUrls = null;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            } else {
                                                                                sourceUrls = null;
                                                                            }
                                                                            if (sourceUrls == null) {
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                            ArrayList<AnichiParser.SourceUrls> $this$forEach$iv3 = sourceUrls;
                                                                            function1 = this.$subtitleCallback;
                                                                            function2 = this.$callback;
                                                                            str2 = this.$dubStatus;
                                                                            while (r12.hasNext()) {
                                                                                AnichiParser.SourceUrls source3 = (AnichiParser.SourceUrls) element$iv;
                                                                                BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source3, function1, function2, str2, null), 3, (Object) null);
                                                                                function1 = function1;
                                                                                function2 = function2;
                                                                                str2 = str2;
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    } catch (Throwable th) {
                                                                        Result.Companion companion4 = Result.Companion;
                                                                        obj8 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                    }
                                                                    if (Result.exceptionOrNull-impl(obj8) != null) {
                                                                        i4 = i3;
                                                                        $this$coroutineScope = $this$coroutineScope3;
                                                                        $this$coroutineScope2 = null;
                                                                    } else {
                                                                        try {
                                                                            Result.Companion companion5 = Result.Companion;
                                                                            i4 = i3;
                                                                            try {
                                                                                $this$coroutineScope = $this$coroutineScope3;
                                                                                $this$coroutineScope2 = null;
                                                                                try {
                                                                                    obj8 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.LinksQuery.class), (List) null, 2, (Object) null));
                                                                                    break;
                                                                                } catch (Throwable th2) {
                                                                                    th = th2;
                                                                                    try {
                                                                                        Result.Companion companion6 = Result.Companion;
                                                                                        obj8 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                                    } catch (Exception e10) {
                                                                                        objDecodeFromString2 = null;
                                                                                    }
                                                                                }
                                                                            } catch (Throwable th3) {
                                                                                th = th3;
                                                                                $this$coroutineScope = $this$coroutineScope3;
                                                                                $this$coroutineScope2 = null;
                                                                            }
                                                                        } catch (Throwable th4) {
                                                                            th = th4;
                                                                            i4 = i3;
                                                                            $this$coroutineScope = $this$coroutineScope3;
                                                                            $this$coroutineScope2 = null;
                                                                        }
                                                                    }
                                                                    if (Result.isFailure-impl(obj8)) {
                                                                        obj8 = $this$coroutineScope2;
                                                                    }
                                                                    deserializationStrategy2 = (KSerializer) obj8;
                                                                    if (deserializationStrategy2 != null) {
                                                                        try {
                                                                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonToParse);
                                                                        } catch (SerializationException e11) {
                                                                            ArchComponentExtKt.logError(e11);
                                                                            ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                                                            objDecodeFromString2 = $this$readValue$iv$iv$iv.readValue(jsonToParse, new TypeReference<AnichiParser.LinksQuery>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$2
                                                                            });
                                                                        } catch (Throwable th5) {
                                                                            ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                                                            objDecodeFromString2 = $this$readValue$iv$iv$iv2.readValue(jsonToParse, new TypeReference<AnichiParser.LinksQuery>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$2
                                                                            });
                                                                        }
                                                                    } else {
                                                                        ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                                                        objDecodeFromString2 = $this$readValue$iv$iv$iv3.readValue(jsonToParse, new TypeReference<AnichiParser.LinksQuery>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$2
                                                                        });
                                                                    }
                                                                    break;
                                                                } else {
                                                                    i4 = i3;
                                                                    $this$coroutineScope = $this$coroutineScope3;
                                                                    objDecodeFromString2 = null;
                                                                }
                                                                it = (AnichiParser.LinksQuery) objDecodeFromString2;
                                                                if (it != null) {
                                                                    data = it.getData();
                                                                    if (data != null) {
                                                                        episode = it.getEpisode();
                                                                        if (episode != null) {
                                                                            sourceUrls = episode.getSourceUrls();
                                                                        } else {
                                                                            sourceUrls = null;
                                                                        }
                                                                    } else {
                                                                        episode = it.getEpisode();
                                                                        if (episode != null) {
                                                                            sourceUrls = episode.getSourceUrls();
                                                                        } else {
                                                                            sourceUrls = null;
                                                                        }
                                                                    }
                                                                    break;
                                                                } else {
                                                                    sourceUrls = null;
                                                                }
                                                                if (sourceUrls == null) {
                                                                    return Unit.INSTANCE;
                                                                }
                                                                ArrayList<AnichiParser.SourceUrls> $this$forEach$iv4 = sourceUrls;
                                                                function1 = this.$subtitleCallback;
                                                                function2 = this.$callback;
                                                                str2 = this.$dubStatus;
                                                                while (r12.hasNext()) {
                                                                    AnichiParser.SourceUrls source4 = (AnichiParser.SourceUrls) element$iv;
                                                                    BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source4, function1, function2, str2, null), 3, (Object) null);
                                                                    function1 = function1;
                                                                    function2 = function2;
                                                                    str2 = str2;
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        } catch (Throwable th6) {
                                                            Result.Companion companion7 = Result.Companion;
                                                            obj4 = Result.constructor-impl(ResultKt.createFailure(th6));
                                                        }
                                                        if (Result.exceptionOrNull-impl(obj4) == null) {
                                                            aaReq4 = finalJson;
                                                        } else {
                                                            try {
                                                                Result.Companion companion8 = Result.Companion;
                                                                aaReq4 = finalJson;
                                                                try {
                                                                    obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(EncryptedResponse.class), (List) null, 2, (Object) null));
                                                                    break;
                                                                } catch (Throwable th7) {
                                                                    th = th7;
                                                                    try {
                                                                        Result.Companion companion9 = Result.Companion;
                                                                        obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                    } catch (Exception e12) {
                                                                        obj5 = null;
                                                                    }
                                                                }
                                                            } catch (Throwable th8) {
                                                                th = th8;
                                                                aaReq4 = finalJson;
                                                            }
                                                        }
                                                        if (Result.isFailure-impl(obj4)) {
                                                            obj6 = null;
                                                        } else {
                                                            obj6 = obj4;
                                                        }
                                                        deserializationStrategy = (KSerializer) obj6;
                                                        if (deserializationStrategy != null) {
                                                            try {
                                                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                                            } catch (SerializationException e13) {
                                                                ArchComponentExtKt.logError(e13);
                                                                ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                                                                objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(value$iv, new TypeReference<EncryptedResponse>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$1
                                                                });
                                                            } catch (Throwable th9) {
                                                                ObjectMapper $this$readValue$iv$iv$iv5 = MainAPIKt.getMapper();
                                                                objDecodeFromString = $this$readValue$iv$iv$iv5.readValue(value$iv, new TypeReference<EncryptedResponse>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$1
                                                                });
                                                            }
                                                        } else {
                                                            ObjectMapper $this$readValue$iv$iv$iv6 = MainAPIKt.getMapper();
                                                            objDecodeFromString = $this$readValue$iv$iv$iv6.readValue(value$iv, new TypeReference<EncryptedResponse>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$1
                                                            });
                                                        }
                                                        obj5 = objDecodeFromString;
                                                        break;
                                                    } else {
                                                        aaReq4 = finalJson;
                                                        obj5 = null;
                                                    }
                                                    encryptedResponse = (EncryptedResponse) obj5;
                                                    if (encryptedResponse != null) {
                                                        encryptedData = encryptedResponse.getData();
                                                    } else {
                                                        encryptedData = null;
                                                    }
                                                    if (encryptedData != null) {
                                                        encrypted = encryptedData.getTobeparsed();
                                                    } else {
                                                        encrypted = null;
                                                    }
                                                    if (encrypted != null) {
                                                        String it3 = encrypted;
                                                        String _mVar2 = encryptedData.get_m();
                                                        this.L$0 = $this$coroutineScope3;
                                                        this.L$1 = responseText3;
                                                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                                                        this.L$3 = SpillingKt.nullOutSpilledVariable(aaReq4);
                                                        this.L$4 = encryptedData;
                                                        this.L$5 = encrypted;
                                                        this.L$6 = SpillingKt.nullOutSpilledVariable(it3);
                                                        this.I$0 = i3;
                                                        this.label = 7;
                                                        objDecodeToBeParsed = AnichiUtilsKt.decodeToBeParsed(it3, _mVar2, this);
                                                        if (objDecodeToBeParsed == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        String str5 = lane;
                                                        lane5 = encrypted;
                                                        obj7 = objDecodeToBeParsed;
                                                        lane6 = str5;
                                                        encryptedData2 = encryptedData;
                                                        encrypted = lane5;
                                                        aaReq5 = (String) obj7;
                                                        lane = lane6;
                                                    } else {
                                                        encryptedData2 = encryptedData;
                                                        aaReq5 = null;
                                                    }
                                                    if (aaReq5 == null) {
                                                    }
                                                    encrypted2 = encrypted;
                                                    if (aaReq5 == null) {
                                                        str3 = responseText3;
                                                    } else {
                                                        str3 = aaReq5;
                                                    }
                                                    jsonToParse = str3;
                                                    Log.INSTANCE.d("Phisher", jsonToParse);
                                                    AppUtils appUtils3 = AppUtils.INSTANCE;
                                                    if (jsonToParse == null) {
                                                        Result.Companion companion10 = Result.Companion;
                                                        KType kTypeTypeOf3 = Reflection.typeOf(AnichiParser.LinksQuery.class);
                                                        MagicApiIntrinsics.voidMagicApiCall(obj);
                                                        obj8 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                                                        if (Result.exceptionOrNull-impl(obj8) != null) {
                                                            Result.Companion companion11 = Result.Companion;
                                                            i4 = i3;
                                                            $this$coroutineScope = $this$coroutineScope3;
                                                            $this$coroutineScope2 = null;
                                                            obj8 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.LinksQuery.class), (List) null, 2, (Object) null));
                                                        } else {
                                                            i4 = i3;
                                                            $this$coroutineScope = $this$coroutineScope3;
                                                            $this$coroutineScope2 = null;
                                                        }
                                                        if (Result.isFailure-impl(obj8)) {
                                                            obj8 = $this$coroutineScope2;
                                                        }
                                                        deserializationStrategy2 = (KSerializer) obj8;
                                                        if (deserializationStrategy2 != null) {
                                                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonToParse);
                                                        } else {
                                                            ObjectMapper $this$readValue$iv$iv$iv7 = MainAPIKt.getMapper();
                                                            objDecodeFromString2 = $this$readValue$iv$iv$iv7.readValue(jsonToParse, new TypeReference<AnichiParser.LinksQuery>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$2
                                                            });
                                                        }
                                                        break;
                                                    } else {
                                                        i4 = i3;
                                                        $this$coroutineScope = $this$coroutineScope3;
                                                        objDecodeFromString2 = null;
                                                    }
                                                    it = (AnichiParser.LinksQuery) objDecodeFromString2;
                                                    if (it != null) {
                                                        data = it.getData();
                                                        if (data != null) {
                                                            episode = it.getEpisode();
                                                            if (episode != null) {
                                                                sourceUrls = episode.getSourceUrls();
                                                            } else {
                                                                sourceUrls = null;
                                                            }
                                                        } else {
                                                            episode = it.getEpisode();
                                                            if (episode != null) {
                                                                sourceUrls = episode.getSourceUrls();
                                                            } else {
                                                                sourceUrls = null;
                                                            }
                                                        }
                                                        break;
                                                    } else {
                                                        sourceUrls = null;
                                                    }
                                                    if (sourceUrls == null) {
                                                        return Unit.INSTANCE;
                                                    }
                                                    ArrayList<AnichiParser.SourceUrls> $this$forEach$iv5 = sourceUrls;
                                                    function1 = this.$subtitleCallback;
                                                    function2 = this.$callback;
                                                    str2 = this.$dubStatus;
                                                    while (r12.hasNext()) {
                                                        AnichiParser.SourceUrls source5 = (AnichiParser.SourceUrls) element$iv;
                                                        BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source5, function1, function2, str2, null), 3, (Object) null);
                                                        function1 = function1;
                                                        function2 = function2;
                                                        str2 = str2;
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                                break;
                                            } else {
                                                finalJson = aaReq;
                                                lane = lane2;
                                                responseText3 = responseText4;
                                            }
                                            if (finalJson != null) {
                                                i = 1;
                                            } else {
                                                i = 1;
                                            }
                                            i2 = i;
                                            if (i2 != 0) {
                                                Log.INSTANCE.d("Anichi", "NEED_CAPTCHA – opening episode WebView to intercept API response…");
                                                String episodePageUrl2 = "https://mkissa.to/bangumi/" + this.$hash + "/p-" + this.$episode + '-' + this.$dubStatus;
                                                this.L$0 = $this$coroutineScope3;
                                                this.L$1 = SpillingKt.nullOutSpilledVariable(responseText3);
                                                this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                                                this.L$3 = SpillingKt.nullOutSpilledVariable(finalJson);
                                                this.L$4 = SpillingKt.nullOutSpilledVariable(episodePageUrl2);
                                                this.L$5 = null;
                                                this.L$6 = null;
                                                this.I$0 = i2;
                                                this.label = 6;
                                                objShowTurnstileDialogAndWait = AnichiExtractors.INSTANCE.showTurnstileDialogAndWait(episodePageUrl2, (Continuation) this);
                                                if (objShowTurnstileDialogAndWait == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                interceptedResponse = (String) objShowTurnstileDialogAndWait;
                                                if (interceptedResponse == null) {
                                                    return Unit.INSTANCE;
                                                }
                                                i3 = i2;
                                                responseText3 = interceptedResponse;
                                            } else {
                                                i3 = i2;
                                            }
                                            AppUtils appUtils4 = AppUtils.INSTANCE;
                                            value$iv = responseText3;
                                            if (value$iv == null) {
                                                Result.Companion companion12 = Result.Companion;
                                                KType kTypeTypeOf4 = Reflection.typeOf(EncryptedResponse.class);
                                                MagicApiIntrinsics.voidMagicApiCall(obj);
                                                obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                                                if (Result.exceptionOrNull-impl(obj4) == null) {
                                                    Result.Companion companion13 = Result.Companion;
                                                    aaReq4 = finalJson;
                                                    obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(EncryptedResponse.class), (List) null, 2, (Object) null));
                                                } else {
                                                    aaReq4 = finalJson;
                                                }
                                                if (Result.isFailure-impl(obj4)) {
                                                    obj6 = null;
                                                } else {
                                                    obj6 = obj4;
                                                }
                                                deserializationStrategy = (KSerializer) obj6;
                                                if (deserializationStrategy != null) {
                                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                                } else {
                                                    ObjectMapper $this$readValue$iv$iv$iv8 = MainAPIKt.getMapper();
                                                    objDecodeFromString = $this$readValue$iv$iv$iv8.readValue(value$iv, new TypeReference<EncryptedResponse>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$1
                                                    });
                                                }
                                                obj5 = objDecodeFromString;
                                                break;
                                            } else {
                                                aaReq4 = finalJson;
                                                obj5 = null;
                                            }
                                            encryptedResponse = (EncryptedResponse) obj5;
                                            if (encryptedResponse != null) {
                                                encryptedData = encryptedResponse.getData();
                                            } else {
                                                encryptedData = null;
                                            }
                                            if (encryptedData != null) {
                                                encrypted = encryptedData.getTobeparsed();
                                            } else {
                                                encrypted = null;
                                            }
                                            if (encrypted != null) {
                                                String it4 = encrypted;
                                                String _mVar3 = encryptedData.get_m();
                                                this.L$0 = $this$coroutineScope3;
                                                this.L$1 = responseText3;
                                                this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                                                this.L$3 = SpillingKt.nullOutSpilledVariable(aaReq4);
                                                this.L$4 = encryptedData;
                                                this.L$5 = encrypted;
                                                this.L$6 = SpillingKt.nullOutSpilledVariable(it4);
                                                this.I$0 = i3;
                                                this.label = 7;
                                                objDecodeToBeParsed = AnichiUtilsKt.decodeToBeParsed(it4, _mVar3, this);
                                                if (objDecodeToBeParsed == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                String str6 = lane;
                                                lane5 = encrypted;
                                                obj7 = objDecodeToBeParsed;
                                                lane6 = str6;
                                                encryptedData2 = encryptedData;
                                                encrypted = lane5;
                                                aaReq5 = (String) obj7;
                                                lane = lane6;
                                            } else {
                                                encryptedData2 = encryptedData;
                                                aaReq5 = null;
                                            }
                                            if (aaReq5 == null) {
                                            }
                                            encrypted2 = encrypted;
                                            if (aaReq5 == null) {
                                                str3 = responseText3;
                                            } else {
                                                str3 = aaReq5;
                                            }
                                            jsonToParse = str3;
                                            try {
                                                Log.INSTANCE.d("Phisher", jsonToParse);
                                                AppUtils appUtils5 = AppUtils.INSTANCE;
                                                if (jsonToParse == null) {
                                                    i4 = i3;
                                                    $this$coroutineScope = $this$coroutineScope3;
                                                    objDecodeFromString2 = null;
                                                } else {
                                                    Result.Companion companion14 = Result.Companion;
                                                    KType kTypeTypeOf5 = Reflection.typeOf(AnichiParser.LinksQuery.class);
                                                    MagicApiIntrinsics.voidMagicApiCall(obj);
                                                    obj8 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                                                    if (Result.exceptionOrNull-impl(obj8) != null) {
                                                        Result.Companion companion15 = Result.Companion;
                                                        i4 = i3;
                                                        $this$coroutineScope = $this$coroutineScope3;
                                                        $this$coroutineScope2 = null;
                                                        obj8 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.LinksQuery.class), (List) null, 2, (Object) null));
                                                    } else {
                                                        i4 = i3;
                                                        $this$coroutineScope = $this$coroutineScope3;
                                                        $this$coroutineScope2 = null;
                                                    }
                                                    if (Result.isFailure-impl(obj8)) {
                                                        obj8 = $this$coroutineScope2;
                                                    }
                                                    deserializationStrategy2 = (KSerializer) obj8;
                                                    if (deserializationStrategy2 != null) {
                                                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonToParse);
                                                    } else {
                                                        ObjectMapper $this$readValue$iv$iv$iv9 = MainAPIKt.getMapper();
                                                        objDecodeFromString2 = $this$readValue$iv$iv$iv9.readValue(jsonToParse, new TypeReference<AnichiParser.LinksQuery>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$2
                                                        });
                                                    }
                                                }
                                                try {
                                                    it = (AnichiParser.LinksQuery) objDecodeFromString2;
                                                    if (it != null) {
                                                        data = it.getData();
                                                        if (data != null) {
                                                            episode = it.getEpisode();
                                                            if (episode != null) {
                                                                sourceUrls = episode.getSourceUrls();
                                                            } else {
                                                                sourceUrls = null;
                                                            }
                                                        } else {
                                                            episode = it.getEpisode();
                                                            if (episode != null) {
                                                                sourceUrls = episode.getSourceUrls();
                                                            } else {
                                                                sourceUrls = null;
                                                            }
                                                        }
                                                    } else {
                                                        sourceUrls = null;
                                                    }
                                                } catch (Exception e14) {
                                                    e = e14;
                                                    finalJson = aaReq4;
                                                    e.printStackTrace();
                                                    sourceUrls = null;
                                                }
                                                break;
                                            } catch (Exception e15) {
                                                e = e15;
                                                $this$coroutineScope = $this$coroutineScope3;
                                                finalJson = aaReq4;
                                            }
                                            if (sourceUrls == null) {
                                                return Unit.INSTANCE;
                                            }
                                            ArrayList<AnichiParser.SourceUrls> $this$forEach$iv6 = sourceUrls;
                                            function1 = this.$subtitleCallback;
                                            function2 = this.$callback;
                                            str2 = this.$dubStatus;
                                            while (r12.hasNext()) {
                                                AnichiParser.SourceUrls source6 = (AnichiParser.SourceUrls) element$iv;
                                                BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source6, function1, function2, str2, null), 3, (Object) null);
                                                function1 = function1;
                                                function2 = function2;
                                                str2 = str2;
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    } catch (Exception e16) {
                                        aaReq2 = aaReq;
                                        fullApiUrl3 = lane3;
                                        fallbackQuery = responseText4;
                                        fullApiUrl4 = lane2;
                                    }
                                } else {
                                    fullApiUrl2 = lane3;
                                }
                                if (StringsKt.contains$default(responseText4, "Too many requests, please try again in", false, 2, (Object) null)) {
                                    matchResultFind$default = Regex.find$default(new Regex("try again in (\\d+)"), responseText4, 0, 2, (Object) null);
                                    if (matchResultFind$default == null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
                                        String str7 = (String) groupValues.get(1);
                                        if (str7 != null && (longOrNull = StringsKt.toLongOrNull(str7)) != null) {
                                            delaySec = longOrNull.longValue();
                                        }
                                        Duration.Companion companion16 = Duration.Companion;
                                        this.L$0 = $this$coroutineScope3;
                                        this.L$1 = SpillingKt.nullOutSpilledVariable(responseText4);
                                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane2);
                                        this.L$3 = aaReq;
                                        this.L$4 = fullApiUrl2;
                                        this.L$5 = null;
                                        this.L$6 = null;
                                        this.J$0 = delaySec;
                                        this.label = 4;
                                        if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration((1000 * delaySec) + 500, DurationUnit.MILLISECONDS), (Continuation) this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        delaySec2 = delaySec;
                                        aaReq3 = aaReq;
                                        lane4 = lane2;
                                        fullApiUrl5 = fullApiUrl2;
                                        this.L$0 = $this$coroutineScope3;
                                        this.L$1 = SpillingKt.nullOutSpilledVariable(responseText4);
                                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane4);
                                        this.L$3 = aaReq3;
                                        this.L$4 = SpillingKt.nullOutSpilledVariable(fullApiUrl5);
                                        this.J$0 = delaySec2;
                                        this.label = 5;
                                        obj3 = Requests.get$default(MainActivityKt.getApp(), fullApiUrl5, Anichi.INSTANCE.getHeaders(), (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4092, (Object) null);
                                        if (obj3 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        text3 = ((NiceResponse) obj3).getText();
                                        responseText3 = text3;
                                        finalJson = aaReq3;
                                        lane = lane4;
                                    }
                                    Duration.Companion companion17 = Duration.Companion;
                                    this.L$0 = $this$coroutineScope3;
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(responseText4);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(lane2);
                                    this.L$3 = aaReq;
                                    this.L$4 = fullApiUrl2;
                                    this.L$5 = null;
                                    this.L$6 = null;
                                    this.J$0 = delaySec;
                                    this.label = 4;
                                    if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration((1000 * delaySec) + 500, DurationUnit.MILLISECONDS), (Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    delaySec2 = delaySec;
                                    aaReq3 = aaReq;
                                    lane4 = lane2;
                                    fullApiUrl5 = fullApiUrl2;
                                    this.L$0 = $this$coroutineScope3;
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(responseText4);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(lane4);
                                    this.L$3 = aaReq3;
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(fullApiUrl5);
                                    this.J$0 = delaySec2;
                                    this.label = 5;
                                    obj3 = Requests.get$default(MainActivityKt.getApp(), fullApiUrl5, Anichi.INSTANCE.getHeaders(), (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4092, (Object) null);
                                    if (obj3 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    text3 = ((NiceResponse) obj3).getText();
                                    responseText3 = text3;
                                    finalJson = aaReq3;
                                    lane = lane4;
                                } else {
                                    finalJson = aaReq;
                                    lane = lane2;
                                    responseText3 = responseText4;
                                }
                            } catch (Exception e17) {
                                lane2 = responseText;
                                lane3 = fullApiUrl;
                                text = "";
                                responseText4 = text;
                                obj = "kotlinx.serialization.serializer.simple";
                                str = "";
                                if (StringsKt.contains$default(responseText4, "PERSISTED_QUERY_NOT_FOUND", false, 2, (Object) null)) {
                                    String postBody2 = "{\"query\":\"query($showId: String!, $translationType: VaildTranslationTypeEnumType!, $episodeString: String!) { episode(showId: $showId, translationType: $translationType, episodeString: $episodeString) { episodeString uploadDate sourceUrls thumbnail notes show { _id type englishName name nativeName nameOnlyString altNames slugTime description availableEpisodes episodeCount lastEpisodeInfo episodeDuration airedStart score thumbnail banner genres isAdult } } }\",\"variables\":{\"showId\":\"" + this.$hash + "\",\"translationType\":\"" + this.$dubStatus + "\",\"episodeString\":\"" + this.$episode + "\"},\"extensions\":{\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"d405d0edd690624b66baba3068e0edc3ac90f1597d898a1ec8db4e5c43c00fec\"},\"k\":\"" + lane2 + "\",\"aaReq\":\"" + aaReq + "\"}}";
                                    Requests app3 = MainActivityKt.getApp();
                                    Map mapPlus2 = MapsKt.plus(Anichi.INSTANCE.getHeaders(), MapsKt.mapOf(TuplesKt.to("Content-Type", "application/json")));
                                    RequestBody requestBodyCreate2 = RequestBody.Companion.create(postBody2, MediaType.Companion.parse("application/json"));
                                    Continuation continuation3 = (Continuation) this;
                                    this.L$0 = $this$coroutineScope3;
                                    this.L$1 = responseText4;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(lane2);
                                    this.L$3 = aaReq;
                                    this.L$4 = lane3;
                                    this.L$5 = SpillingKt.nullOutSpilledVariable("query($showId: String!, $translationType: VaildTranslationTypeEnumType!, $episodeString: String!) { episode(showId: $showId, translationType: $translationType, episodeString: $episodeString) { episodeString uploadDate sourceUrls thumbnail notes show { _id type englishName name nativeName nameOnlyString altNames slugTime description availableEpisodes episodeCount lastEpisodeInfo episodeDuration airedStart score thumbnail banner genres isAdult } } }");
                                    this.L$6 = SpillingKt.nullOutSpilledVariable(postBody2);
                                    this.label = 3;
                                    objPost$default = Requests.post$default(app3, Anichi.apiUrl, mapPlus2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, continuation3, 65276, (Object) null);
                                    if (objPost$default == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    aaReq2 = aaReq;
                                    fullApiUrl3 = lane3;
                                    fallbackQuery = responseText4;
                                    fullApiUrl4 = lane2;
                                    text2 = ((NiceResponse) objPost$default).getText();
                                    aaReq = aaReq2;
                                    lane2 = fullApiUrl4;
                                    responseText4 = text2;
                                    fullApiUrl2 = fullApiUrl3;
                                } else {
                                    fullApiUrl2 = lane3;
                                }
                                if (StringsKt.contains$default(responseText4, "Too many requests, please try again in", false, 2, (Object) null)) {
                                    matchResultFind$default = Regex.find$default(new Regex("try again in (\\d+)"), responseText4, 0, 2, (Object) null);
                                    if (matchResultFind$default == null) {
                                    }
                                    Duration.Companion companion18 = Duration.Companion;
                                    this.L$0 = $this$coroutineScope3;
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(responseText4);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(lane2);
                                    this.L$3 = aaReq;
                                    this.L$4 = fullApiUrl2;
                                    this.L$5 = null;
                                    this.L$6 = null;
                                    this.J$0 = delaySec;
                                    this.label = 4;
                                    if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration((1000 * delaySec) + 500, DurationUnit.MILLISECONDS), (Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    delaySec2 = delaySec;
                                    aaReq3 = aaReq;
                                    lane4 = lane2;
                                    fullApiUrl5 = fullApiUrl2;
                                    this.L$0 = $this$coroutineScope3;
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(responseText4);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(lane4);
                                    this.L$3 = aaReq3;
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(fullApiUrl5);
                                    this.J$0 = delaySec2;
                                    this.label = 5;
                                    obj3 = Requests.get$default(MainActivityKt.getApp(), fullApiUrl5, Anichi.INSTANCE.getHeaders(), (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4092, (Object) null);
                                    if (obj3 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    text3 = ((NiceResponse) obj3).getText();
                                    responseText3 = text3;
                                    finalJson = aaReq3;
                                    lane = lane4;
                                } else {
                                    finalJson = aaReq;
                                    lane = lane2;
                                    responseText3 = responseText4;
                                }
                                if (finalJson != null) {
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                                i2 = i;
                                if (i2 != 0) {
                                    Log.INSTANCE.d("Anichi", "NEED_CAPTCHA – opening episode WebView to intercept API response…");
                                    String episodePageUrl3 = "https://mkissa.to/bangumi/" + this.$hash + "/p-" + this.$episode + '-' + this.$dubStatus;
                                    this.L$0 = $this$coroutineScope3;
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(responseText3);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(finalJson);
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(episodePageUrl3);
                                    this.L$5 = null;
                                    this.L$6 = null;
                                    this.I$0 = i2;
                                    this.label = 6;
                                    objShowTurnstileDialogAndWait = AnichiExtractors.INSTANCE.showTurnstileDialogAndWait(episodePageUrl3, (Continuation) this);
                                    if (objShowTurnstileDialogAndWait == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    interceptedResponse = (String) objShowTurnstileDialogAndWait;
                                    if (interceptedResponse == null) {
                                        return Unit.INSTANCE;
                                    }
                                    i3 = i2;
                                    responseText3 = interceptedResponse;
                                } else {
                                    i3 = i2;
                                }
                                AppUtils appUtils6 = AppUtils.INSTANCE;
                                value$iv = responseText3;
                                if (value$iv == null) {
                                    Result.Companion companion19 = Result.Companion;
                                    KType kTypeTypeOf6 = Reflection.typeOf(EncryptedResponse.class);
                                    MagicApiIntrinsics.voidMagicApiCall(obj);
                                    obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                                    if (Result.exceptionOrNull-impl(obj4) == null) {
                                        Result.Companion companion110 = Result.Companion;
                                        aaReq4 = finalJson;
                                        obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(EncryptedResponse.class), (List) null, 2, (Object) null));
                                    } else {
                                        aaReq4 = finalJson;
                                    }
                                    if (Result.isFailure-impl(obj4)) {
                                        obj6 = null;
                                    } else {
                                        obj6 = obj4;
                                    }
                                    deserializationStrategy = (KSerializer) obj6;
                                    if (deserializationStrategy != null) {
                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                    } else {
                                        ObjectMapper $this$readValue$iv$iv$iv10 = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv$iv10.readValue(value$iv, new TypeReference<EncryptedResponse>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$1
                                        });
                                    }
                                    obj5 = objDecodeFromString;
                                    break;
                                } else {
                                    aaReq4 = finalJson;
                                    obj5 = null;
                                }
                                encryptedResponse = (EncryptedResponse) obj5;
                                if (encryptedResponse != null) {
                                    encryptedData = encryptedResponse.getData();
                                } else {
                                    encryptedData = null;
                                }
                                if (encryptedData != null) {
                                    encrypted = encryptedData.getTobeparsed();
                                } else {
                                    encrypted = null;
                                }
                                if (encrypted != null) {
                                    String it5 = encrypted;
                                    String _mVar4 = encryptedData.get_m();
                                    this.L$0 = $this$coroutineScope3;
                                    this.L$1 = responseText3;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(aaReq4);
                                    this.L$4 = encryptedData;
                                    this.L$5 = encrypted;
                                    this.L$6 = SpillingKt.nullOutSpilledVariable(it5);
                                    this.I$0 = i3;
                                    this.label = 7;
                                    objDecodeToBeParsed = AnichiUtilsKt.decodeToBeParsed(it5, _mVar4, this);
                                    if (objDecodeToBeParsed == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    String str8 = lane;
                                    lane5 = encrypted;
                                    obj7 = objDecodeToBeParsed;
                                    lane6 = str8;
                                    encryptedData2 = encryptedData;
                                    encrypted = lane5;
                                    aaReq5 = (String) obj7;
                                    lane = lane6;
                                } else {
                                    encryptedData2 = encryptedData;
                                    aaReq5 = null;
                                }
                                if (aaReq5 == null) {
                                }
                                encrypted2 = encrypted;
                                if (aaReq5 == null) {
                                    str3 = responseText3;
                                } else {
                                    str3 = aaReq5;
                                }
                                jsonToParse = str3;
                                Log.INSTANCE.d("Phisher", jsonToParse);
                                AppUtils appUtils7 = AppUtils.INSTANCE;
                                if (jsonToParse == null) {
                                    Result.Companion companion111 = Result.Companion;
                                    KType kTypeTypeOf7 = Reflection.typeOf(AnichiParser.LinksQuery.class);
                                    MagicApiIntrinsics.voidMagicApiCall(obj);
                                    obj8 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf7));
                                    if (Result.exceptionOrNull-impl(obj8) != null) {
                                        Result.Companion companion112 = Result.Companion;
                                        i4 = i3;
                                        $this$coroutineScope = $this$coroutineScope3;
                                        $this$coroutineScope2 = null;
                                        obj8 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.LinksQuery.class), (List) null, 2, (Object) null));
                                    } else {
                                        i4 = i3;
                                        $this$coroutineScope = $this$coroutineScope3;
                                        $this$coroutineScope2 = null;
                                    }
                                    if (Result.isFailure-impl(obj8)) {
                                        obj8 = $this$coroutineScope2;
                                    }
                                    deserializationStrategy2 = (KSerializer) obj8;
                                    if (deserializationStrategy2 != null) {
                                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonToParse);
                                    } else {
                                        ObjectMapper $this$readValue$iv$iv$iv11 = MainAPIKt.getMapper();
                                        objDecodeFromString2 = $this$readValue$iv$iv$iv11.readValue(jsonToParse, new TypeReference<AnichiParser.LinksQuery>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$2
                                        });
                                    }
                                    break;
                                } else {
                                    i4 = i3;
                                    $this$coroutineScope = $this$coroutineScope3;
                                    objDecodeFromString2 = null;
                                }
                                it = (AnichiParser.LinksQuery) objDecodeFromString2;
                                if (it != null) {
                                    data = it.getData();
                                    if (data != null) {
                                        episode = it.getEpisode();
                                        if (episode != null) {
                                            sourceUrls = episode.getSourceUrls();
                                        } else {
                                            sourceUrls = null;
                                        }
                                    } else {
                                        episode = it.getEpisode();
                                        if (episode != null) {
                                            sourceUrls = episode.getSourceUrls();
                                        } else {
                                            sourceUrls = null;
                                        }
                                    }
                                    break;
                                } else {
                                    sourceUrls = null;
                                }
                                if (sourceUrls == null) {
                                    return Unit.INSTANCE;
                                }
                                ArrayList<AnichiParser.SourceUrls> $this$forEach$iv7 = sourceUrls;
                                function1 = this.$subtitleCallback;
                                function2 = this.$callback;
                                str2 = this.$dubStatus;
                                while (r12.hasNext()) {
                                    AnichiParser.SourceUrls source7 = (AnichiParser.SourceUrls) element$iv;
                                    BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source7, function1, function2, str2, null), 3, (Object) null);
                                    function1 = function1;
                                    function2 = function2;
                                    str2 = str2;
                                }
                                return Unit.INSTANCE;
                            }
                        } catch (Exception e18) {
                            lane2 = responseText;
                            lane3 = fullApiUrl;
                        }
                        break;
                    } else {
                        obj = "kotlinx.serialization.serializer.simple";
                        finalJson = aaReq;
                        lane = responseText;
                        responseText3 = responseText2;
                    }
                    if (finalJson != null || !StringsKt.startsWith$default(StringsKt.trim(responseText3).toString(), "{", false, 2, (Object) null) || StringsKt.contains$default(responseText3, "NEED_CAPTCHA", false, 2, (Object) null) || StringsKt.contains$default(responseText3, "AA_CRYPTO_MISSING", false, 2, (Object) null) || StringsKt.contains$default(responseText3, "AA_CRYPTO_STALE", false, 2, (Object) null)) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    i2 = i;
                    if (i2 != 0) {
                        Log.INSTANCE.d("Anichi", "NEED_CAPTCHA – opening episode WebView to intercept API response…");
                        String episodePageUrl4 = "https://mkissa.to/bangumi/" + this.$hash + "/p-" + this.$episode + '-' + this.$dubStatus;
                        this.L$0 = $this$coroutineScope3;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(responseText3);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(finalJson);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(episodePageUrl4);
                        this.L$5 = null;
                        this.L$6 = null;
                        this.I$0 = i2;
                        this.label = 6;
                        objShowTurnstileDialogAndWait = AnichiExtractors.INSTANCE.showTurnstileDialogAndWait(episodePageUrl4, (Continuation) this);
                        if (objShowTurnstileDialogAndWait == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        interceptedResponse = (String) objShowTurnstileDialogAndWait;
                        if (interceptedResponse == null) {
                            return Unit.INSTANCE;
                        }
                        i3 = i2;
                        responseText3 = interceptedResponse;
                    } else {
                        i3 = i2;
                    }
                    try {
                        AppUtils appUtils8 = AppUtils.INSTANCE;
                        value$iv = responseText3;
                        if (value$iv == null) {
                            aaReq4 = finalJson;
                            obj5 = null;
                        } else {
                            Result.Companion companion113 = Result.Companion;
                            KType kTypeTypeOf8 = Reflection.typeOf(EncryptedResponse.class);
                            MagicApiIntrinsics.voidMagicApiCall(obj);
                            obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf8));
                            if (Result.exceptionOrNull-impl(obj4) == null) {
                                Result.Companion companion114 = Result.Companion;
                                aaReq4 = finalJson;
                                obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(EncryptedResponse.class), (List) null, 2, (Object) null));
                            } else {
                                aaReq4 = finalJson;
                            }
                            if (Result.isFailure-impl(obj4)) {
                                obj6 = null;
                            } else {
                                obj6 = obj4;
                            }
                            deserializationStrategy = (KSerializer) obj6;
                            if (deserializationStrategy != null) {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv12 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv12.readValue(value$iv, new TypeReference<EncryptedResponse>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$1
                                });
                            }
                            obj5 = objDecodeFromString;
                        }
                        try {
                            encryptedResponse = (EncryptedResponse) obj5;
                            if (encryptedResponse != null) {
                                encryptedData = encryptedResponse.getData();
                            } else {
                                encryptedData = null;
                            }
                            if (encryptedData != null) {
                                encrypted = encryptedData.getTobeparsed();
                            } else {
                                encrypted = null;
                            }
                            if (encrypted != null) {
                                String it6 = encrypted;
                                String _mVar5 = encryptedData.get_m();
                                this.L$0 = $this$coroutineScope3;
                                this.L$1 = responseText3;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(aaReq4);
                                this.L$4 = encryptedData;
                                this.L$5 = encrypted;
                                this.L$6 = SpillingKt.nullOutSpilledVariable(it6);
                                this.I$0 = i3;
                                this.label = 7;
                                objDecodeToBeParsed = AnichiUtilsKt.decodeToBeParsed(it6, _mVar5, this);
                                if (objDecodeToBeParsed == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                String str9 = lane;
                                lane5 = encrypted;
                                obj7 = objDecodeToBeParsed;
                                lane6 = str9;
                                encryptedData2 = encryptedData;
                                encrypted = lane5;
                                aaReq5 = (String) obj7;
                                lane = lane6;
                            } else {
                                encryptedData2 = encryptedData;
                                aaReq5 = null;
                            }
                            if (aaReq5 == null || encrypted == null) {
                                encrypted2 = encrypted;
                            } else {
                                Log.INSTANCE.d("Anichi", "First decryption attempt failed — resetting crypto cache and retrying with fresh key");
                                AnichiUtilsKt.resetCryptoCache();
                                this.L$0 = $this$coroutineScope3;
                                this.L$1 = responseText3;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(aaReq4);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(encryptedData2);
                                this.L$5 = SpillingKt.nullOutSpilledVariable(encrypted);
                                this.L$6 = SpillingKt.nullOutSpilledVariable(aaReq5);
                                this.I$0 = i3;
                                this.label = 8;
                                objDecodeToBeParsed2 = AnichiUtilsKt.decodeToBeParsed(encrypted, encryptedData2.get_m(), (Continuation) this);
                                if (objDecodeToBeParsed2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                encrypted2 = encrypted;
                                finalJson = aaReq4;
                                aaReq4 = finalJson;
                                aaReq5 = (String) objDecodeToBeParsed2;
                            }
                            if (aaReq5 == null) {
                                str3 = responseText3;
                            } else {
                                str3 = aaReq5;
                            }
                            jsonToParse = str3;
                            Log.INSTANCE.d("Phisher", jsonToParse);
                            AppUtils appUtils9 = AppUtils.INSTANCE;
                            if (jsonToParse == null) {
                                i4 = i3;
                                $this$coroutineScope = $this$coroutineScope3;
                                objDecodeFromString2 = null;
                            } else {
                                Result.Companion companion115 = Result.Companion;
                                KType kTypeTypeOf9 = Reflection.typeOf(AnichiParser.LinksQuery.class);
                                MagicApiIntrinsics.voidMagicApiCall(obj);
                                obj8 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf9));
                                if (Result.exceptionOrNull-impl(obj8) != null) {
                                    Result.Companion companion116 = Result.Companion;
                                    i4 = i3;
                                    $this$coroutineScope = $this$coroutineScope3;
                                    $this$coroutineScope2 = null;
                                    obj8 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.LinksQuery.class), (List) null, 2, (Object) null));
                                } else {
                                    i4 = i3;
                                    $this$coroutineScope = $this$coroutineScope3;
                                    $this$coroutineScope2 = null;
                                }
                                if (Result.isFailure-impl(obj8)) {
                                    obj8 = $this$coroutineScope2;
                                }
                                deserializationStrategy2 = (KSerializer) obj8;
                                if (deserializationStrategy2 != null) {
                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonToParse);
                                } else {
                                    ObjectMapper $this$readValue$iv$iv$iv13 = MainAPIKt.getMapper();
                                    objDecodeFromString2 = $this$readValue$iv$iv$iv13.readValue(jsonToParse, new TypeReference<AnichiParser.LinksQuery>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$2
                                    });
                                }
                            }
                            it = (AnichiParser.LinksQuery) objDecodeFromString2;
                            if (it != null) {
                                data = it.getData();
                                if (data != null || (episode2 = data.getEpisode()) == null || (sourceUrls2 = episode2.getSourceUrls()) == null) {
                                    episode = it.getEpisode();
                                    if (episode != null) {
                                        sourceUrls = episode.getSourceUrls();
                                    } else {
                                        sourceUrls = null;
                                    }
                                } else {
                                    sourceUrls = sourceUrls2;
                                }
                            } else {
                                sourceUrls = null;
                            }
                        } catch (Exception e19) {
                            e = e19;
                            $this$coroutineScope = $this$coroutineScope3;
                            finalJson = aaReq4;
                            e.printStackTrace();
                            sourceUrls = null;
                            if (sourceUrls == null) {
                                return Unit.INSTANCE;
                            }
                            ArrayList<AnichiParser.SourceUrls> $this$forEach$iv8 = sourceUrls;
                            function1 = this.$subtitleCallback;
                            function2 = this.$callback;
                            str2 = this.$dubStatus;
                            while (r12.hasNext()) {
                                AnichiParser.SourceUrls source8 = (AnichiParser.SourceUrls) element$iv;
                                BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source8, function1, function2, str2, null), 3, (Object) null);
                                function1 = function1;
                                function2 = function2;
                                str2 = str2;
                            }
                            return Unit.INSTANCE;
                        }
                        break;
                    } catch (Exception e20) {
                        e = e20;
                        $this$coroutineScope = $this$coroutineScope3;
                    }
                    if (sourceUrls == null) {
                        return Unit.INSTANCE;
                    }
                    ArrayList<AnichiParser.SourceUrls> $this$forEach$iv9 = sourceUrls;
                    function1 = this.$subtitleCallback;
                    function2 = this.$callback;
                    str2 = this.$dubStatus;
                    while (r12.hasNext()) {
                        AnichiParser.SourceUrls source9 = (AnichiParser.SourceUrls) element$iv;
                        BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source9, function1, function2, str2, null), 3, (Object) null);
                        function1 = function1;
                        function2 = function2;
                        str2 = str2;
                    }
                    return Unit.INSTANCE;
                case 1:
                    String lane7 = (String) this.L$2;
                    String responseText5 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    objGenerateAaReq = $result;
                    responseText2 = responseText5;
                    responseText = lane7;
                    aaReq = (String) objGenerateAaReq;
                    if (aaReq != null) {
                        fullApiUrl = "https://api.allanime.day/api?variables={\"showId\":\"" + this.$hash + "\",\"translationType\":\"" + this.$dubStatus + "\",\"episodeString\":\"" + this.$episode + "\"}&extensions={\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"d405d0edd690624b66baba3068e0edc3ac90f1597d898a1ec8db4e5c43c00fec\"},\"k\":\"" + responseText + "\",\"aaReq\":\"" + aaReq + "\"}";
                        Requests app4 = MainActivityKt.getApp();
                        Map<String, String> headers2 = Anichi.INSTANCE.getHeaders();
                        Continuation continuation4 = (Continuation) this;
                        this.L$0 = $this$coroutineScope3;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(responseText2);
                        this.L$2 = responseText;
                        this.L$3 = aaReq;
                        this.L$4 = fullApiUrl;
                        this.label = 2;
                        obj2 = Requests.get$default(app4, fullApiUrl, headers2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, continuation4, 4092, (Object) null);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        lane2 = responseText;
                        lane3 = fullApiUrl;
                        text = ((NiceResponse) obj2).getText();
                        responseText4 = text;
                        obj = "kotlinx.serialization.serializer.simple";
                        str = "";
                        if (StringsKt.contains$default(responseText4, "PERSISTED_QUERY_NOT_FOUND", false, 2, (Object) null)) {
                            String postBody3 = "{\"query\":\"query($showId: String!, $translationType: VaildTranslationTypeEnumType!, $episodeString: String!) { episode(showId: $showId, translationType: $translationType, episodeString: $episodeString) { episodeString uploadDate sourceUrls thumbnail notes show { _id type englishName name nativeName nameOnlyString altNames slugTime description availableEpisodes episodeCount lastEpisodeInfo episodeDuration airedStart score thumbnail banner genres isAdult } } }\",\"variables\":{\"showId\":\"" + this.$hash + "\",\"translationType\":\"" + this.$dubStatus + "\",\"episodeString\":\"" + this.$episode + "\"},\"extensions\":{\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"d405d0edd690624b66baba3068e0edc3ac90f1597d898a1ec8db4e5c43c00fec\"},\"k\":\"" + lane2 + "\",\"aaReq\":\"" + aaReq + "\"}}";
                            Requests app5 = MainActivityKt.getApp();
                            Map mapPlus3 = MapsKt.plus(Anichi.INSTANCE.getHeaders(), MapsKt.mapOf(TuplesKt.to("Content-Type", "application/json")));
                            RequestBody requestBodyCreate3 = RequestBody.Companion.create(postBody3, MediaType.Companion.parse("application/json"));
                            Continuation continuation5 = (Continuation) this;
                            this.L$0 = $this$coroutineScope3;
                            this.L$1 = responseText4;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(lane2);
                            this.L$3 = aaReq;
                            this.L$4 = lane3;
                            this.L$5 = SpillingKt.nullOutSpilledVariable("query($showId: String!, $translationType: VaildTranslationTypeEnumType!, $episodeString: String!) { episode(showId: $showId, translationType: $translationType, episodeString: $episodeString) { episodeString uploadDate sourceUrls thumbnail notes show { _id type englishName name nativeName nameOnlyString altNames slugTime description availableEpisodes episodeCount lastEpisodeInfo episodeDuration airedStart score thumbnail banner genres isAdult } } }");
                            this.L$6 = SpillingKt.nullOutSpilledVariable(postBody3);
                            this.label = 3;
                            objPost$default = Requests.post$default(app5, Anichi.apiUrl, mapPlus3, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate3, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, continuation5, 65276, (Object) null);
                            if (objPost$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            aaReq2 = aaReq;
                            fullApiUrl3 = lane3;
                            fallbackQuery = responseText4;
                            fullApiUrl4 = lane2;
                            text2 = ((NiceResponse) objPost$default).getText();
                            aaReq = aaReq2;
                            lane2 = fullApiUrl4;
                            responseText4 = text2;
                            fullApiUrl2 = fullApiUrl3;
                        } else {
                            fullApiUrl2 = lane3;
                        }
                        if (StringsKt.contains$default(responseText4, "Too many requests, please try again in", false, 2, (Object) null)) {
                            matchResultFind$default = Regex.find$default(new Regex("try again in (\\d+)"), responseText4, 0, 2, (Object) null);
                            if (matchResultFind$default == null) {
                            }
                            Duration.Companion companion117 = Duration.Companion;
                            this.L$0 = $this$coroutineScope3;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(responseText4);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(lane2);
                            this.L$3 = aaReq;
                            this.L$4 = fullApiUrl2;
                            this.L$5 = null;
                            this.L$6 = null;
                            this.J$0 = delaySec;
                            this.label = 4;
                            if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration((1000 * delaySec) + 500, DurationUnit.MILLISECONDS), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            delaySec2 = delaySec;
                            aaReq3 = aaReq;
                            lane4 = lane2;
                            fullApiUrl5 = fullApiUrl2;
                            this.L$0 = $this$coroutineScope3;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(responseText4);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(lane4);
                            this.L$3 = aaReq3;
                            this.L$4 = SpillingKt.nullOutSpilledVariable(fullApiUrl5);
                            this.J$0 = delaySec2;
                            this.label = 5;
                            obj3 = Requests.get$default(MainActivityKt.getApp(), fullApiUrl5, Anichi.INSTANCE.getHeaders(), (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4092, (Object) null);
                            if (obj3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            text3 = ((NiceResponse) obj3).getText();
                            responseText3 = text3;
                            finalJson = aaReq3;
                            lane = lane4;
                        } else {
                            finalJson = aaReq;
                            lane = lane2;
                            responseText3 = responseText4;
                        }
                    } else {
                        obj = "kotlinx.serialization.serializer.simple";
                        finalJson = aaReq;
                        lane = responseText;
                        responseText3 = responseText2;
                    }
                    if (finalJson != null) {
                        i = 1;
                    } else {
                        i = 1;
                    }
                    i2 = i;
                    if (i2 != 0) {
                        Log.INSTANCE.d("Anichi", "NEED_CAPTCHA – opening episode WebView to intercept API response…");
                        String episodePageUrl5 = "https://mkissa.to/bangumi/" + this.$hash + "/p-" + this.$episode + '-' + this.$dubStatus;
                        this.L$0 = $this$coroutineScope3;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(responseText3);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(finalJson);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(episodePageUrl5);
                        this.L$5 = null;
                        this.L$6 = null;
                        this.I$0 = i2;
                        this.label = 6;
                        objShowTurnstileDialogAndWait = AnichiExtractors.INSTANCE.showTurnstileDialogAndWait(episodePageUrl5, (Continuation) this);
                        if (objShowTurnstileDialogAndWait == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        interceptedResponse = (String) objShowTurnstileDialogAndWait;
                        if (interceptedResponse == null) {
                            return Unit.INSTANCE;
                        }
                        i3 = i2;
                        responseText3 = interceptedResponse;
                    } else {
                        i3 = i2;
                    }
                    AppUtils appUtils10 = AppUtils.INSTANCE;
                    value$iv = responseText3;
                    if (value$iv == null) {
                        Result.Companion companion118 = Result.Companion;
                        KType kTypeTypeOf10 = Reflection.typeOf(EncryptedResponse.class);
                        MagicApiIntrinsics.voidMagicApiCall(obj);
                        obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf10));
                        if (Result.exceptionOrNull-impl(obj4) == null) {
                            Result.Companion companion119 = Result.Companion;
                            aaReq4 = finalJson;
                            obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(EncryptedResponse.class), (List) null, 2, (Object) null));
                        } else {
                            aaReq4 = finalJson;
                        }
                        if (Result.isFailure-impl(obj4)) {
                            obj6 = null;
                        } else {
                            obj6 = obj4;
                        }
                        deserializationStrategy = (KSerializer) obj6;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv14 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv14.readValue(value$iv, new TypeReference<EncryptedResponse>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$1
                            });
                        }
                        obj5 = objDecodeFromString;
                        break;
                    } else {
                        aaReq4 = finalJson;
                        obj5 = null;
                    }
                    encryptedResponse = (EncryptedResponse) obj5;
                    if (encryptedResponse != null) {
                        encryptedData = encryptedResponse.getData();
                    } else {
                        encryptedData = null;
                    }
                    if (encryptedData != null) {
                        encrypted = encryptedData.getTobeparsed();
                    } else {
                        encrypted = null;
                    }
                    if (encrypted != null) {
                        String it7 = encrypted;
                        String _mVar6 = encryptedData.get_m();
                        this.L$0 = $this$coroutineScope3;
                        this.L$1 = responseText3;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(aaReq4);
                        this.L$4 = encryptedData;
                        this.L$5 = encrypted;
                        this.L$6 = SpillingKt.nullOutSpilledVariable(it7);
                        this.I$0 = i3;
                        this.label = 7;
                        objDecodeToBeParsed = AnichiUtilsKt.decodeToBeParsed(it7, _mVar6, this);
                        if (objDecodeToBeParsed == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        String str10 = lane;
                        lane5 = encrypted;
                        obj7 = objDecodeToBeParsed;
                        lane6 = str10;
                        encryptedData2 = encryptedData;
                        encrypted = lane5;
                        aaReq5 = (String) obj7;
                        lane = lane6;
                    } else {
                        encryptedData2 = encryptedData;
                        aaReq5 = null;
                    }
                    if (aaReq5 == null) {
                    }
                    encrypted2 = encrypted;
                    if (aaReq5 == null) {
                        str3 = responseText3;
                    } else {
                        str3 = aaReq5;
                    }
                    jsonToParse = str3;
                    Log.INSTANCE.d("Phisher", jsonToParse);
                    AppUtils appUtils11 = AppUtils.INSTANCE;
                    if (jsonToParse == null) {
                        Result.Companion companion1110 = Result.Companion;
                        KType kTypeTypeOf11 = Reflection.typeOf(AnichiParser.LinksQuery.class);
                        MagicApiIntrinsics.voidMagicApiCall(obj);
                        obj8 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf11));
                        if (Result.exceptionOrNull-impl(obj8) != null) {
                            Result.Companion companion1111 = Result.Companion;
                            i4 = i3;
                            $this$coroutineScope = $this$coroutineScope3;
                            $this$coroutineScope2 = null;
                            obj8 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.LinksQuery.class), (List) null, 2, (Object) null));
                        } else {
                            i4 = i3;
                            $this$coroutineScope = $this$coroutineScope3;
                            $this$coroutineScope2 = null;
                        }
                        if (Result.isFailure-impl(obj8)) {
                            obj8 = $this$coroutineScope2;
                        }
                        deserializationStrategy2 = (KSerializer) obj8;
                        if (deserializationStrategy2 != null) {
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonToParse);
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv15 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv$iv15.readValue(jsonToParse, new TypeReference<AnichiParser.LinksQuery>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$2
                            });
                        }
                        break;
                    } else {
                        i4 = i3;
                        $this$coroutineScope = $this$coroutineScope3;
                        objDecodeFromString2 = null;
                    }
                    it = (AnichiParser.LinksQuery) objDecodeFromString2;
                    if (it != null) {
                        data = it.getData();
                        if (data != null) {
                            episode = it.getEpisode();
                            if (episode != null) {
                                sourceUrls = episode.getSourceUrls();
                            } else {
                                sourceUrls = null;
                            }
                        } else {
                            episode = it.getEpisode();
                            if (episode != null) {
                                sourceUrls = episode.getSourceUrls();
                            } else {
                                sourceUrls = null;
                            }
                        }
                        break;
                    } else {
                        sourceUrls = null;
                    }
                    if (sourceUrls == null) {
                        return Unit.INSTANCE;
                    }
                    ArrayList<AnichiParser.SourceUrls> $this$forEach$iv10 = sourceUrls;
                    function1 = this.$subtitleCallback;
                    function2 = this.$callback;
                    str2 = this.$dubStatus;
                    while (r12.hasNext()) {
                        AnichiParser.SourceUrls source10 = (AnichiParser.SourceUrls) element$iv;
                        BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source10, function1, function2, str2, null), 3, (Object) null);
                        function1 = function1;
                        function2 = function2;
                        str2 = str2;
                    }
                    return Unit.INSTANCE;
                case 2:
                    lane3 = (String) this.L$4;
                    String aaReq6 = (String) this.L$3;
                    String lane8 = (String) this.L$2;
                    try {
                        ResultKt.throwOnFailure($result);
                        obj2 = $result;
                        aaReq = aaReq6;
                        lane2 = lane8;
                        text = ((NiceResponse) obj2).getText();
                        break;
                    } catch (Exception e21) {
                        aaReq = aaReq6;
                        lane2 = lane8;
                        text = "";
                        responseText4 = text;
                        obj = "kotlinx.serialization.serializer.simple";
                        str = "";
                        if (StringsKt.contains$default(responseText4, "PERSISTED_QUERY_NOT_FOUND", false, 2, (Object) null)) {
                            String postBody4 = "{\"query\":\"query($showId: String!, $translationType: VaildTranslationTypeEnumType!, $episodeString: String!) { episode(showId: $showId, translationType: $translationType, episodeString: $episodeString) { episodeString uploadDate sourceUrls thumbnail notes show { _id type englishName name nativeName nameOnlyString altNames slugTime description availableEpisodes episodeCount lastEpisodeInfo episodeDuration airedStart score thumbnail banner genres isAdult } } }\",\"variables\":{\"showId\":\"" + this.$hash + "\",\"translationType\":\"" + this.$dubStatus + "\",\"episodeString\":\"" + this.$episode + "\"},\"extensions\":{\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"d405d0edd690624b66baba3068e0edc3ac90f1597d898a1ec8db4e5c43c00fec\"},\"k\":\"" + lane2 + "\",\"aaReq\":\"" + aaReq + "\"}}";
                            Requests app6 = MainActivityKt.getApp();
                            Map mapPlus4 = MapsKt.plus(Anichi.INSTANCE.getHeaders(), MapsKt.mapOf(TuplesKt.to("Content-Type", "application/json")));
                            RequestBody requestBodyCreate4 = RequestBody.Companion.create(postBody4, MediaType.Companion.parse("application/json"));
                            Continuation continuation6 = (Continuation) this;
                            this.L$0 = $this$coroutineScope3;
                            this.L$1 = responseText4;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(lane2);
                            this.L$3 = aaReq;
                            this.L$4 = lane3;
                            this.L$5 = SpillingKt.nullOutSpilledVariable("query($showId: String!, $translationType: VaildTranslationTypeEnumType!, $episodeString: String!) { episode(showId: $showId, translationType: $translationType, episodeString: $episodeString) { episodeString uploadDate sourceUrls thumbnail notes show { _id type englishName name nativeName nameOnlyString altNames slugTime description availableEpisodes episodeCount lastEpisodeInfo episodeDuration airedStart score thumbnail banner genres isAdult } } }");
                            this.L$6 = SpillingKt.nullOutSpilledVariable(postBody4);
                            this.label = 3;
                            objPost$default = Requests.post$default(app6, Anichi.apiUrl, mapPlus4, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate4, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, continuation6, 65276, (Object) null);
                            if (objPost$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            aaReq2 = aaReq;
                            fullApiUrl3 = lane3;
                            fallbackQuery = responseText4;
                            fullApiUrl4 = lane2;
                            text2 = ((NiceResponse) objPost$default).getText();
                            aaReq = aaReq2;
                            lane2 = fullApiUrl4;
                            responseText4 = text2;
                            fullApiUrl2 = fullApiUrl3;
                        } else {
                            fullApiUrl2 = lane3;
                        }
                        if (StringsKt.contains$default(responseText4, "Too many requests, please try again in", false, 2, (Object) null)) {
                            matchResultFind$default = Regex.find$default(new Regex("try again in (\\d+)"), responseText4, 0, 2, (Object) null);
                            if (matchResultFind$default == null) {
                            }
                            Duration.Companion companion1112 = Duration.Companion;
                            this.L$0 = $this$coroutineScope3;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(responseText4);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(lane2);
                            this.L$3 = aaReq;
                            this.L$4 = fullApiUrl2;
                            this.L$5 = null;
                            this.L$6 = null;
                            this.J$0 = delaySec;
                            this.label = 4;
                            if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration((1000 * delaySec) + 500, DurationUnit.MILLISECONDS), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            delaySec2 = delaySec;
                            aaReq3 = aaReq;
                            lane4 = lane2;
                            fullApiUrl5 = fullApiUrl2;
                            this.L$0 = $this$coroutineScope3;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(responseText4);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(lane4);
                            this.L$3 = aaReq3;
                            this.L$4 = SpillingKt.nullOutSpilledVariable(fullApiUrl5);
                            this.J$0 = delaySec2;
                            this.label = 5;
                            obj3 = Requests.get$default(MainActivityKt.getApp(), fullApiUrl5, Anichi.INSTANCE.getHeaders(), (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4092, (Object) null);
                            if (obj3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            text3 = ((NiceResponse) obj3).getText();
                            responseText3 = text3;
                            finalJson = aaReq3;
                            lane = lane4;
                        } else {
                            finalJson = aaReq;
                            lane = lane2;
                            responseText3 = responseText4;
                        }
                        if (finalJson != null) {
                            i = 1;
                        } else {
                            i = 1;
                        }
                        i2 = i;
                        if (i2 != 0) {
                            Log.INSTANCE.d("Anichi", "NEED_CAPTCHA – opening episode WebView to intercept API response…");
                            String episodePageUrl6 = "https://mkissa.to/bangumi/" + this.$hash + "/p-" + this.$episode + '-' + this.$dubStatus;
                            this.L$0 = $this$coroutineScope3;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(responseText3);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(finalJson);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(episodePageUrl6);
                            this.L$5 = null;
                            this.L$6 = null;
                            this.I$0 = i2;
                            this.label = 6;
                            objShowTurnstileDialogAndWait = AnichiExtractors.INSTANCE.showTurnstileDialogAndWait(episodePageUrl6, (Continuation) this);
                            if (objShowTurnstileDialogAndWait == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            interceptedResponse = (String) objShowTurnstileDialogAndWait;
                            if (interceptedResponse == null) {
                                return Unit.INSTANCE;
                            }
                            i3 = i2;
                            responseText3 = interceptedResponse;
                        } else {
                            i3 = i2;
                        }
                        AppUtils appUtils12 = AppUtils.INSTANCE;
                        value$iv = responseText3;
                        if (value$iv == null) {
                            Result.Companion companion1113 = Result.Companion;
                            KType kTypeTypeOf12 = Reflection.typeOf(EncryptedResponse.class);
                            MagicApiIntrinsics.voidMagicApiCall(obj);
                            obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf12));
                            if (Result.exceptionOrNull-impl(obj4) == null) {
                                Result.Companion companion1114 = Result.Companion;
                                aaReq4 = finalJson;
                                obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(EncryptedResponse.class), (List) null, 2, (Object) null));
                            } else {
                                aaReq4 = finalJson;
                            }
                            if (Result.isFailure-impl(obj4)) {
                                obj6 = null;
                            } else {
                                obj6 = obj4;
                            }
                            deserializationStrategy = (KSerializer) obj6;
                            if (deserializationStrategy != null) {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv16 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv16.readValue(value$iv, new TypeReference<EncryptedResponse>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$1
                                });
                            }
                            obj5 = objDecodeFromString;
                            break;
                        } else {
                            aaReq4 = finalJson;
                            obj5 = null;
                        }
                        encryptedResponse = (EncryptedResponse) obj5;
                        if (encryptedResponse != null) {
                            encryptedData = encryptedResponse.getData();
                        } else {
                            encryptedData = null;
                        }
                        if (encryptedData != null) {
                            encrypted = encryptedData.getTobeparsed();
                        } else {
                            encrypted = null;
                        }
                        if (encrypted != null) {
                            String it8 = encrypted;
                            String _mVar7 = encryptedData.get_m();
                            this.L$0 = $this$coroutineScope3;
                            this.L$1 = responseText3;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(aaReq4);
                            this.L$4 = encryptedData;
                            this.L$5 = encrypted;
                            this.L$6 = SpillingKt.nullOutSpilledVariable(it8);
                            this.I$0 = i3;
                            this.label = 7;
                            objDecodeToBeParsed = AnichiUtilsKt.decodeToBeParsed(it8, _mVar7, this);
                            if (objDecodeToBeParsed == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            String str11 = lane;
                            lane5 = encrypted;
                            obj7 = objDecodeToBeParsed;
                            lane6 = str11;
                            encryptedData2 = encryptedData;
                            encrypted = lane5;
                            aaReq5 = (String) obj7;
                            lane = lane6;
                        } else {
                            encryptedData2 = encryptedData;
                            aaReq5 = null;
                        }
                        if (aaReq5 == null) {
                        }
                        encrypted2 = encrypted;
                        if (aaReq5 == null) {
                            str3 = responseText3;
                        } else {
                            str3 = aaReq5;
                        }
                        jsonToParse = str3;
                        Log.INSTANCE.d("Phisher", jsonToParse);
                        AppUtils appUtils13 = AppUtils.INSTANCE;
                        if (jsonToParse == null) {
                            Result.Companion companion1115 = Result.Companion;
                            KType kTypeTypeOf13 = Reflection.typeOf(AnichiParser.LinksQuery.class);
                            MagicApiIntrinsics.voidMagicApiCall(obj);
                            obj8 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf13));
                            if (Result.exceptionOrNull-impl(obj8) != null) {
                                Result.Companion companion1116 = Result.Companion;
                                i4 = i3;
                                $this$coroutineScope = $this$coroutineScope3;
                                $this$coroutineScope2 = null;
                                obj8 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.LinksQuery.class), (List) null, 2, (Object) null));
                            } else {
                                i4 = i3;
                                $this$coroutineScope = $this$coroutineScope3;
                                $this$coroutineScope2 = null;
                            }
                            if (Result.isFailure-impl(obj8)) {
                                obj8 = $this$coroutineScope2;
                            }
                            deserializationStrategy2 = (KSerializer) obj8;
                            if (deserializationStrategy2 != null) {
                                objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonToParse);
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv17 = MainAPIKt.getMapper();
                                objDecodeFromString2 = $this$readValue$iv$iv$iv17.readValue(jsonToParse, new TypeReference<AnichiParser.LinksQuery>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$2
                                });
                            }
                            break;
                        } else {
                            i4 = i3;
                            $this$coroutineScope = $this$coroutineScope3;
                            objDecodeFromString2 = null;
                        }
                        it = (AnichiParser.LinksQuery) objDecodeFromString2;
                        if (it != null) {
                            data = it.getData();
                            if (data != null) {
                                episode = it.getEpisode();
                                if (episode != null) {
                                    sourceUrls = episode.getSourceUrls();
                                } else {
                                    sourceUrls = null;
                                }
                            } else {
                                episode = it.getEpisode();
                                if (episode != null) {
                                    sourceUrls = episode.getSourceUrls();
                                } else {
                                    sourceUrls = null;
                                }
                            }
                            break;
                        } else {
                            sourceUrls = null;
                        }
                        if (sourceUrls == null) {
                            return Unit.INSTANCE;
                        }
                        ArrayList<AnichiParser.SourceUrls> $this$forEach$iv11 = sourceUrls;
                        function1 = this.$subtitleCallback;
                        function2 = this.$callback;
                        str2 = this.$dubStatus;
                        while (r12.hasNext()) {
                            AnichiParser.SourceUrls source11 = (AnichiParser.SourceUrls) element$iv;
                            BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source11, function1, function2, str2, null), 3, (Object) null);
                            function1 = function1;
                            function2 = function2;
                            str2 = str2;
                        }
                        return Unit.INSTANCE;
                    }
                    responseText4 = text;
                    obj = "kotlinx.serialization.serializer.simple";
                    str = "";
                    if (StringsKt.contains$default(responseText4, "PERSISTED_QUERY_NOT_FOUND", false, 2, (Object) null)) {
                        String postBody5 = "{\"query\":\"query($showId: String!, $translationType: VaildTranslationTypeEnumType!, $episodeString: String!) { episode(showId: $showId, translationType: $translationType, episodeString: $episodeString) { episodeString uploadDate sourceUrls thumbnail notes show { _id type englishName name nativeName nameOnlyString altNames slugTime description availableEpisodes episodeCount lastEpisodeInfo episodeDuration airedStart score thumbnail banner genres isAdult } } }\",\"variables\":{\"showId\":\"" + this.$hash + "\",\"translationType\":\"" + this.$dubStatus + "\",\"episodeString\":\"" + this.$episode + "\"},\"extensions\":{\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"d405d0edd690624b66baba3068e0edc3ac90f1597d898a1ec8db4e5c43c00fec\"},\"k\":\"" + lane2 + "\",\"aaReq\":\"" + aaReq + "\"}}";
                        Requests app7 = MainActivityKt.getApp();
                        Map mapPlus5 = MapsKt.plus(Anichi.INSTANCE.getHeaders(), MapsKt.mapOf(TuplesKt.to("Content-Type", "application/json")));
                        RequestBody requestBodyCreate5 = RequestBody.Companion.create(postBody5, MediaType.Companion.parse("application/json"));
                        Continuation continuation7 = (Continuation) this;
                        this.L$0 = $this$coroutineScope3;
                        this.L$1 = responseText4;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane2);
                        this.L$3 = aaReq;
                        this.L$4 = lane3;
                        this.L$5 = SpillingKt.nullOutSpilledVariable("query($showId: String!, $translationType: VaildTranslationTypeEnumType!, $episodeString: String!) { episode(showId: $showId, translationType: $translationType, episodeString: $episodeString) { episodeString uploadDate sourceUrls thumbnail notes show { _id type englishName name nativeName nameOnlyString altNames slugTime description availableEpisodes episodeCount lastEpisodeInfo episodeDuration airedStart score thumbnail banner genres isAdult } } }");
                        this.L$6 = SpillingKt.nullOutSpilledVariable(postBody5);
                        this.label = 3;
                        objPost$default = Requests.post$default(app7, Anichi.apiUrl, mapPlus5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate5, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, continuation7, 65276, (Object) null);
                        if (objPost$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        aaReq2 = aaReq;
                        fullApiUrl3 = lane3;
                        fallbackQuery = responseText4;
                        fullApiUrl4 = lane2;
                        text2 = ((NiceResponse) objPost$default).getText();
                        aaReq = aaReq2;
                        lane2 = fullApiUrl4;
                        responseText4 = text2;
                        fullApiUrl2 = fullApiUrl3;
                    } else {
                        fullApiUrl2 = lane3;
                    }
                    if (StringsKt.contains$default(responseText4, "Too many requests, please try again in", false, 2, (Object) null)) {
                        matchResultFind$default = Regex.find$default(new Regex("try again in (\\d+)"), responseText4, 0, 2, (Object) null);
                        if (matchResultFind$default == null) {
                        }
                        Duration.Companion companion1117 = Duration.Companion;
                        this.L$0 = $this$coroutineScope3;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(responseText4);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane2);
                        this.L$3 = aaReq;
                        this.L$4 = fullApiUrl2;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.J$0 = delaySec;
                        this.label = 4;
                        if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration((1000 * delaySec) + 500, DurationUnit.MILLISECONDS), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        delaySec2 = delaySec;
                        aaReq3 = aaReq;
                        lane4 = lane2;
                        fullApiUrl5 = fullApiUrl2;
                        this.L$0 = $this$coroutineScope3;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(responseText4);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane4);
                        this.L$3 = aaReq3;
                        this.L$4 = SpillingKt.nullOutSpilledVariable(fullApiUrl5);
                        this.J$0 = delaySec2;
                        this.label = 5;
                        obj3 = Requests.get$default(MainActivityKt.getApp(), fullApiUrl5, Anichi.INSTANCE.getHeaders(), (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4092, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        text3 = ((NiceResponse) obj3).getText();
                        responseText3 = text3;
                        finalJson = aaReq3;
                        lane = lane4;
                    } else {
                        finalJson = aaReq;
                        lane = lane2;
                        responseText3 = responseText4;
                    }
                    if (finalJson != null) {
                        i = 1;
                    } else {
                        i = 1;
                    }
                    i2 = i;
                    if (i2 != 0) {
                        Log.INSTANCE.d("Anichi", "NEED_CAPTCHA – opening episode WebView to intercept API response…");
                        String episodePageUrl7 = "https://mkissa.to/bangumi/" + this.$hash + "/p-" + this.$episode + '-' + this.$dubStatus;
                        this.L$0 = $this$coroutineScope3;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(responseText3);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(finalJson);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(episodePageUrl7);
                        this.L$5 = null;
                        this.L$6 = null;
                        this.I$0 = i2;
                        this.label = 6;
                        objShowTurnstileDialogAndWait = AnichiExtractors.INSTANCE.showTurnstileDialogAndWait(episodePageUrl7, (Continuation) this);
                        if (objShowTurnstileDialogAndWait == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        interceptedResponse = (String) objShowTurnstileDialogAndWait;
                        if (interceptedResponse == null) {
                            return Unit.INSTANCE;
                        }
                        i3 = i2;
                        responseText3 = interceptedResponse;
                    } else {
                        i3 = i2;
                    }
                    AppUtils appUtils14 = AppUtils.INSTANCE;
                    value$iv = responseText3;
                    if (value$iv == null) {
                        Result.Companion companion1118 = Result.Companion;
                        KType kTypeTypeOf14 = Reflection.typeOf(EncryptedResponse.class);
                        MagicApiIntrinsics.voidMagicApiCall(obj);
                        obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf14));
                        if (Result.exceptionOrNull-impl(obj4) == null) {
                            Result.Companion companion1119 = Result.Companion;
                            aaReq4 = finalJson;
                            obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(EncryptedResponse.class), (List) null, 2, (Object) null));
                        } else {
                            aaReq4 = finalJson;
                        }
                        if (Result.isFailure-impl(obj4)) {
                            obj6 = null;
                        } else {
                            obj6 = obj4;
                        }
                        deserializationStrategy = (KSerializer) obj6;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv18 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv18.readValue(value$iv, new TypeReference<EncryptedResponse>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$1
                            });
                        }
                        obj5 = objDecodeFromString;
                        break;
                    } else {
                        aaReq4 = finalJson;
                        obj5 = null;
                    }
                    encryptedResponse = (EncryptedResponse) obj5;
                    if (encryptedResponse != null) {
                        encryptedData = encryptedResponse.getData();
                    } else {
                        encryptedData = null;
                    }
                    if (encryptedData != null) {
                        encrypted = encryptedData.getTobeparsed();
                    } else {
                        encrypted = null;
                    }
                    if (encrypted != null) {
                        String it9 = encrypted;
                        String _mVar8 = encryptedData.get_m();
                        this.L$0 = $this$coroutineScope3;
                        this.L$1 = responseText3;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(aaReq4);
                        this.L$4 = encryptedData;
                        this.L$5 = encrypted;
                        this.L$6 = SpillingKt.nullOutSpilledVariable(it9);
                        this.I$0 = i3;
                        this.label = 7;
                        objDecodeToBeParsed = AnichiUtilsKt.decodeToBeParsed(it9, _mVar8, this);
                        if (objDecodeToBeParsed == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        String str12 = lane;
                        lane5 = encrypted;
                        obj7 = objDecodeToBeParsed;
                        lane6 = str12;
                        encryptedData2 = encryptedData;
                        encrypted = lane5;
                        aaReq5 = (String) obj7;
                        lane = lane6;
                    } else {
                        encryptedData2 = encryptedData;
                        aaReq5 = null;
                    }
                    if (aaReq5 == null) {
                    }
                    encrypted2 = encrypted;
                    if (aaReq5 == null) {
                        str3 = responseText3;
                    } else {
                        str3 = aaReq5;
                    }
                    jsonToParse = str3;
                    Log.INSTANCE.d("Phisher", jsonToParse);
                    AppUtils appUtils15 = AppUtils.INSTANCE;
                    if (jsonToParse == null) {
                        Result.Companion companion11110 = Result.Companion;
                        KType kTypeTypeOf15 = Reflection.typeOf(AnichiParser.LinksQuery.class);
                        MagicApiIntrinsics.voidMagicApiCall(obj);
                        obj8 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf15));
                        if (Result.exceptionOrNull-impl(obj8) != null) {
                            Result.Companion companion11111 = Result.Companion;
                            i4 = i3;
                            $this$coroutineScope = $this$coroutineScope3;
                            $this$coroutineScope2 = null;
                            obj8 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.LinksQuery.class), (List) null, 2, (Object) null));
                        } else {
                            i4 = i3;
                            $this$coroutineScope = $this$coroutineScope3;
                            $this$coroutineScope2 = null;
                        }
                        if (Result.isFailure-impl(obj8)) {
                            obj8 = $this$coroutineScope2;
                        }
                        deserializationStrategy2 = (KSerializer) obj8;
                        if (deserializationStrategy2 != null) {
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonToParse);
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv19 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv$iv19.readValue(jsonToParse, new TypeReference<AnichiParser.LinksQuery>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$2
                            });
                        }
                        break;
                    } else {
                        i4 = i3;
                        $this$coroutineScope = $this$coroutineScope3;
                        objDecodeFromString2 = null;
                    }
                    it = (AnichiParser.LinksQuery) objDecodeFromString2;
                    if (it != null) {
                        data = it.getData();
                        if (data != null) {
                            episode = it.getEpisode();
                            if (episode != null) {
                                sourceUrls = episode.getSourceUrls();
                            } else {
                                sourceUrls = null;
                            }
                        } else {
                            episode = it.getEpisode();
                            if (episode != null) {
                                sourceUrls = episode.getSourceUrls();
                            } else {
                                sourceUrls = null;
                            }
                        }
                        break;
                    } else {
                        sourceUrls = null;
                    }
                    if (sourceUrls == null) {
                        return Unit.INSTANCE;
                    }
                    ArrayList<AnichiParser.SourceUrls> $this$forEach$iv12 = sourceUrls;
                    function1 = this.$subtitleCallback;
                    function2 = this.$callback;
                    str2 = this.$dubStatus;
                    while (r12.hasNext()) {
                        AnichiParser.SourceUrls source12 = (AnichiParser.SourceUrls) element$iv;
                        BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source12, function1, function2, str2, null), 3, (Object) null);
                        function1 = function1;
                        function2 = function2;
                        str2 = str2;
                    }
                    return Unit.INSTANCE;
                case 3:
                    fullApiUrl3 = (String) this.L$4;
                    aaReq2 = (String) this.L$3;
                    fullApiUrl4 = (String) this.L$2;
                    String responseText6 = (String) this.L$1;
                    try {
                        ResultKt.throwOnFailure($result);
                        objPost$default = $result;
                        obj = "kotlinx.serialization.serializer.simple";
                        str = "";
                        fallbackQuery = responseText6;
                        text2 = ((NiceResponse) objPost$default).getText();
                        aaReq = aaReq2;
                        lane2 = fullApiUrl4;
                    } catch (Exception e22) {
                        obj = "kotlinx.serialization.serializer.simple";
                        str = "";
                        fallbackQuery = responseText6;
                        text2 = fallbackQuery;
                        aaReq = aaReq2;
                        lane2 = fullApiUrl4;
                        responseText4 = text2;
                        fullApiUrl2 = fullApiUrl3;
                        if (StringsKt.contains$default(responseText4, "Too many requests, please try again in", false, 2, (Object) null)) {
                            matchResultFind$default = Regex.find$default(new Regex("try again in (\\d+)"), responseText4, 0, 2, (Object) null);
                            if (matchResultFind$default == null) {
                            }
                            Duration.Companion companion11112 = Duration.Companion;
                            this.L$0 = $this$coroutineScope3;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(responseText4);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(lane2);
                            this.L$3 = aaReq;
                            this.L$4 = fullApiUrl2;
                            this.L$5 = null;
                            this.L$6 = null;
                            this.J$0 = delaySec;
                            this.label = 4;
                            if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration((1000 * delaySec) + 500, DurationUnit.MILLISECONDS), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            delaySec2 = delaySec;
                            aaReq3 = aaReq;
                            lane4 = lane2;
                            fullApiUrl5 = fullApiUrl2;
                            this.L$0 = $this$coroutineScope3;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(responseText4);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(lane4);
                            this.L$3 = aaReq3;
                            this.L$4 = SpillingKt.nullOutSpilledVariable(fullApiUrl5);
                            this.J$0 = delaySec2;
                            this.label = 5;
                            obj3 = Requests.get$default(MainActivityKt.getApp(), fullApiUrl5, Anichi.INSTANCE.getHeaders(), (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4092, (Object) null);
                            if (obj3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            text3 = ((NiceResponse) obj3).getText();
                            responseText3 = text3;
                            finalJson = aaReq3;
                            lane = lane4;
                        } else {
                            finalJson = aaReq;
                            lane = lane2;
                            responseText3 = responseText4;
                        }
                        if (finalJson != null) {
                            i = 1;
                        } else {
                            i = 1;
                        }
                        i2 = i;
                        if (i2 != 0) {
                            Log.INSTANCE.d("Anichi", "NEED_CAPTCHA – opening episode WebView to intercept API response…");
                            String episodePageUrl8 = "https://mkissa.to/bangumi/" + this.$hash + "/p-" + this.$episode + '-' + this.$dubStatus;
                            this.L$0 = $this$coroutineScope3;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(responseText3);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(finalJson);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(episodePageUrl8);
                            this.L$5 = null;
                            this.L$6 = null;
                            this.I$0 = i2;
                            this.label = 6;
                            objShowTurnstileDialogAndWait = AnichiExtractors.INSTANCE.showTurnstileDialogAndWait(episodePageUrl8, (Continuation) this);
                            if (objShowTurnstileDialogAndWait == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            interceptedResponse = (String) objShowTurnstileDialogAndWait;
                            if (interceptedResponse == null) {
                                return Unit.INSTANCE;
                            }
                            i3 = i2;
                            responseText3 = interceptedResponse;
                        } else {
                            i3 = i2;
                        }
                        AppUtils appUtils16 = AppUtils.INSTANCE;
                        value$iv = responseText3;
                        if (value$iv == null) {
                            Result.Companion companion11113 = Result.Companion;
                            KType kTypeTypeOf16 = Reflection.typeOf(EncryptedResponse.class);
                            MagicApiIntrinsics.voidMagicApiCall(obj);
                            obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf16));
                            if (Result.exceptionOrNull-impl(obj4) == null) {
                                Result.Companion companion11114 = Result.Companion;
                                aaReq4 = finalJson;
                                obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(EncryptedResponse.class), (List) null, 2, (Object) null));
                            } else {
                                aaReq4 = finalJson;
                            }
                            if (Result.isFailure-impl(obj4)) {
                                obj6 = null;
                            } else {
                                obj6 = obj4;
                            }
                            deserializationStrategy = (KSerializer) obj6;
                            if (deserializationStrategy != null) {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv110 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv110.readValue(value$iv, new TypeReference<EncryptedResponse>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$1
                                });
                            }
                            obj5 = objDecodeFromString;
                            break;
                        } else {
                            aaReq4 = finalJson;
                            obj5 = null;
                        }
                        encryptedResponse = (EncryptedResponse) obj5;
                        if (encryptedResponse != null) {
                            encryptedData = encryptedResponse.getData();
                        } else {
                            encryptedData = null;
                        }
                        if (encryptedData != null) {
                            encrypted = encryptedData.getTobeparsed();
                        } else {
                            encrypted = null;
                        }
                        if (encrypted != null) {
                            String it10 = encrypted;
                            String _mVar9 = encryptedData.get_m();
                            this.L$0 = $this$coroutineScope3;
                            this.L$1 = responseText3;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(aaReq4);
                            this.L$4 = encryptedData;
                            this.L$5 = encrypted;
                            this.L$6 = SpillingKt.nullOutSpilledVariable(it10);
                            this.I$0 = i3;
                            this.label = 7;
                            objDecodeToBeParsed = AnichiUtilsKt.decodeToBeParsed(it10, _mVar9, this);
                            if (objDecodeToBeParsed == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            String str13 = lane;
                            lane5 = encrypted;
                            obj7 = objDecodeToBeParsed;
                            lane6 = str13;
                            encryptedData2 = encryptedData;
                            encrypted = lane5;
                            aaReq5 = (String) obj7;
                            lane = lane6;
                        } else {
                            encryptedData2 = encryptedData;
                            aaReq5 = null;
                        }
                        if (aaReq5 == null) {
                        }
                        encrypted2 = encrypted;
                        if (aaReq5 == null) {
                            str3 = responseText3;
                        } else {
                            str3 = aaReq5;
                        }
                        jsonToParse = str3;
                        Log.INSTANCE.d("Phisher", jsonToParse);
                        AppUtils appUtils17 = AppUtils.INSTANCE;
                        if (jsonToParse == null) {
                            Result.Companion companion11115 = Result.Companion;
                            KType kTypeTypeOf17 = Reflection.typeOf(AnichiParser.LinksQuery.class);
                            MagicApiIntrinsics.voidMagicApiCall(obj);
                            obj8 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf17));
                            if (Result.exceptionOrNull-impl(obj8) != null) {
                                Result.Companion companion11116 = Result.Companion;
                                i4 = i3;
                                $this$coroutineScope = $this$coroutineScope3;
                                $this$coroutineScope2 = null;
                                obj8 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.LinksQuery.class), (List) null, 2, (Object) null));
                            } else {
                                i4 = i3;
                                $this$coroutineScope = $this$coroutineScope3;
                                $this$coroutineScope2 = null;
                            }
                            if (Result.isFailure-impl(obj8)) {
                                obj8 = $this$coroutineScope2;
                            }
                            deserializationStrategy2 = (KSerializer) obj8;
                            if (deserializationStrategy2 != null) {
                                objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonToParse);
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv111 = MainAPIKt.getMapper();
                                objDecodeFromString2 = $this$readValue$iv$iv$iv111.readValue(jsonToParse, new TypeReference<AnichiParser.LinksQuery>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$2
                                });
                            }
                            break;
                        } else {
                            i4 = i3;
                            $this$coroutineScope = $this$coroutineScope3;
                            objDecodeFromString2 = null;
                        }
                        it = (AnichiParser.LinksQuery) objDecodeFromString2;
                        if (it != null) {
                            data = it.getData();
                            if (data != null) {
                                episode = it.getEpisode();
                                if (episode != null) {
                                    sourceUrls = episode.getSourceUrls();
                                } else {
                                    sourceUrls = null;
                                }
                            } else {
                                episode = it.getEpisode();
                                if (episode != null) {
                                    sourceUrls = episode.getSourceUrls();
                                } else {
                                    sourceUrls = null;
                                }
                            }
                            break;
                        } else {
                            sourceUrls = null;
                        }
                        if (sourceUrls == null) {
                            return Unit.INSTANCE;
                        }
                        ArrayList<AnichiParser.SourceUrls> $this$forEach$iv13 = sourceUrls;
                        function1 = this.$subtitleCallback;
                        function2 = this.$callback;
                        str2 = this.$dubStatus;
                        while (r12.hasNext()) {
                            AnichiParser.SourceUrls source13 = (AnichiParser.SourceUrls) element$iv;
                            BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source13, function1, function2, str2, null), 3, (Object) null);
                            function1 = function1;
                            function2 = function2;
                            str2 = str2;
                        }
                        return Unit.INSTANCE;
                    }
                    responseText4 = text2;
                    fullApiUrl2 = fullApiUrl3;
                    if (StringsKt.contains$default(responseText4, "Too many requests, please try again in", false, 2, (Object) null)) {
                        matchResultFind$default = Regex.find$default(new Regex("try again in (\\d+)"), responseText4, 0, 2, (Object) null);
                        if (matchResultFind$default == null) {
                        }
                        Duration.Companion companion11117 = Duration.Companion;
                        this.L$0 = $this$coroutineScope3;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(responseText4);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane2);
                        this.L$3 = aaReq;
                        this.L$4 = fullApiUrl2;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.J$0 = delaySec;
                        this.label = 4;
                        if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration((1000 * delaySec) + 500, DurationUnit.MILLISECONDS), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        delaySec2 = delaySec;
                        aaReq3 = aaReq;
                        lane4 = lane2;
                        fullApiUrl5 = fullApiUrl2;
                        this.L$0 = $this$coroutineScope3;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(responseText4);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane4);
                        this.L$3 = aaReq3;
                        this.L$4 = SpillingKt.nullOutSpilledVariable(fullApiUrl5);
                        this.J$0 = delaySec2;
                        this.label = 5;
                        obj3 = Requests.get$default(MainActivityKt.getApp(), fullApiUrl5, Anichi.INSTANCE.getHeaders(), (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4092, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        text3 = ((NiceResponse) obj3).getText();
                        responseText3 = text3;
                        finalJson = aaReq3;
                        lane = lane4;
                    } else {
                        finalJson = aaReq;
                        lane = lane2;
                        responseText3 = responseText4;
                    }
                    if (finalJson != null) {
                        i = 1;
                    } else {
                        i = 1;
                    }
                    i2 = i;
                    if (i2 != 0) {
                        Log.INSTANCE.d("Anichi", "NEED_CAPTCHA – opening episode WebView to intercept API response…");
                        String episodePageUrl9 = "https://mkissa.to/bangumi/" + this.$hash + "/p-" + this.$episode + '-' + this.$dubStatus;
                        this.L$0 = $this$coroutineScope3;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(responseText3);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(finalJson);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(episodePageUrl9);
                        this.L$5 = null;
                        this.L$6 = null;
                        this.I$0 = i2;
                        this.label = 6;
                        objShowTurnstileDialogAndWait = AnichiExtractors.INSTANCE.showTurnstileDialogAndWait(episodePageUrl9, (Continuation) this);
                        if (objShowTurnstileDialogAndWait == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        interceptedResponse = (String) objShowTurnstileDialogAndWait;
                        if (interceptedResponse == null) {
                            return Unit.INSTANCE;
                        }
                        i3 = i2;
                        responseText3 = interceptedResponse;
                    } else {
                        i3 = i2;
                    }
                    AppUtils appUtils18 = AppUtils.INSTANCE;
                    value$iv = responseText3;
                    if (value$iv == null) {
                        Result.Companion companion11118 = Result.Companion;
                        KType kTypeTypeOf18 = Reflection.typeOf(EncryptedResponse.class);
                        MagicApiIntrinsics.voidMagicApiCall(obj);
                        obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf18));
                        if (Result.exceptionOrNull-impl(obj4) == null) {
                            Result.Companion companion11119 = Result.Companion;
                            aaReq4 = finalJson;
                            obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(EncryptedResponse.class), (List) null, 2, (Object) null));
                        } else {
                            aaReq4 = finalJson;
                        }
                        if (Result.isFailure-impl(obj4)) {
                            obj6 = null;
                        } else {
                            obj6 = obj4;
                        }
                        deserializationStrategy = (KSerializer) obj6;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv112 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv112.readValue(value$iv, new TypeReference<EncryptedResponse>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$1
                            });
                        }
                        obj5 = objDecodeFromString;
                        break;
                    } else {
                        aaReq4 = finalJson;
                        obj5 = null;
                    }
                    encryptedResponse = (EncryptedResponse) obj5;
                    if (encryptedResponse != null) {
                        encryptedData = encryptedResponse.getData();
                    } else {
                        encryptedData = null;
                    }
                    if (encryptedData != null) {
                        encrypted = encryptedData.getTobeparsed();
                    } else {
                        encrypted = null;
                    }
                    if (encrypted != null) {
                        String it11 = encrypted;
                        String _mVar10 = encryptedData.get_m();
                        this.L$0 = $this$coroutineScope3;
                        this.L$1 = responseText3;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(aaReq4);
                        this.L$4 = encryptedData;
                        this.L$5 = encrypted;
                        this.L$6 = SpillingKt.nullOutSpilledVariable(it11);
                        this.I$0 = i3;
                        this.label = 7;
                        objDecodeToBeParsed = AnichiUtilsKt.decodeToBeParsed(it11, _mVar10, this);
                        if (objDecodeToBeParsed == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        String str14 = lane;
                        lane5 = encrypted;
                        obj7 = objDecodeToBeParsed;
                        lane6 = str14;
                        encryptedData2 = encryptedData;
                        encrypted = lane5;
                        aaReq5 = (String) obj7;
                        lane = lane6;
                    } else {
                        encryptedData2 = encryptedData;
                        aaReq5 = null;
                    }
                    if (aaReq5 == null) {
                    }
                    encrypted2 = encrypted;
                    if (aaReq5 == null) {
                        str3 = responseText3;
                    } else {
                        str3 = aaReq5;
                    }
                    jsonToParse = str3;
                    Log.INSTANCE.d("Phisher", jsonToParse);
                    AppUtils appUtils19 = AppUtils.INSTANCE;
                    if (jsonToParse == null) {
                        Result.Companion companion111110 = Result.Companion;
                        KType kTypeTypeOf19 = Reflection.typeOf(AnichiParser.LinksQuery.class);
                        MagicApiIntrinsics.voidMagicApiCall(obj);
                        obj8 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf19));
                        if (Result.exceptionOrNull-impl(obj8) != null) {
                            Result.Companion companion111111 = Result.Companion;
                            i4 = i3;
                            $this$coroutineScope = $this$coroutineScope3;
                            $this$coroutineScope2 = null;
                            obj8 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.LinksQuery.class), (List) null, 2, (Object) null));
                        } else {
                            i4 = i3;
                            $this$coroutineScope = $this$coroutineScope3;
                            $this$coroutineScope2 = null;
                        }
                        if (Result.isFailure-impl(obj8)) {
                            obj8 = $this$coroutineScope2;
                        }
                        deserializationStrategy2 = (KSerializer) obj8;
                        if (deserializationStrategy2 != null) {
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonToParse);
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv113 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv$iv113.readValue(jsonToParse, new TypeReference<AnichiParser.LinksQuery>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$2
                            });
                        }
                        break;
                    } else {
                        i4 = i3;
                        $this$coroutineScope = $this$coroutineScope3;
                        objDecodeFromString2 = null;
                    }
                    it = (AnichiParser.LinksQuery) objDecodeFromString2;
                    if (it != null) {
                        data = it.getData();
                        if (data != null) {
                            episode = it.getEpisode();
                            if (episode != null) {
                                sourceUrls = episode.getSourceUrls();
                            } else {
                                sourceUrls = null;
                            }
                        } else {
                            episode = it.getEpisode();
                            if (episode != null) {
                                sourceUrls = episode.getSourceUrls();
                            } else {
                                sourceUrls = null;
                            }
                        }
                        break;
                    } else {
                        sourceUrls = null;
                    }
                    if (sourceUrls == null) {
                        return Unit.INSTANCE;
                    }
                    ArrayList<AnichiParser.SourceUrls> $this$forEach$iv14 = sourceUrls;
                    function1 = this.$subtitleCallback;
                    function2 = this.$callback;
                    str2 = this.$dubStatus;
                    while (r12.hasNext()) {
                        AnichiParser.SourceUrls source14 = (AnichiParser.SourceUrls) element$iv;
                        BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source14, function1, function2, str2, null), 3, (Object) null);
                        function1 = function1;
                        function2 = function2;
                        str2 = str2;
                    }
                    return Unit.INSTANCE;
                case 4:
                    delaySec2 = this.J$0;
                    String fullApiUrl6 = (String) this.L$4;
                    String aaReq7 = (String) this.L$3;
                    String lane9 = (String) this.L$2;
                    String responseText7 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    obj = "kotlinx.serialization.serializer.simple";
                    str = "";
                    responseText4 = responseText7;
                    lane4 = lane9;
                    aaReq3 = aaReq7;
                    fullApiUrl5 = fullApiUrl6;
                    this.L$0 = $this$coroutineScope3;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(responseText4);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(lane4);
                    this.L$3 = aaReq3;
                    this.L$4 = SpillingKt.nullOutSpilledVariable(fullApiUrl5);
                    this.J$0 = delaySec2;
                    this.label = 5;
                    obj3 = Requests.get$default(MainActivityKt.getApp(), fullApiUrl5, Anichi.INSTANCE.getHeaders(), (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4092, (Object) null);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    text3 = ((NiceResponse) obj3).getText();
                    responseText3 = text3;
                    finalJson = aaReq3;
                    lane = lane4;
                    if (finalJson != null) {
                        i = 1;
                    } else {
                        i = 1;
                    }
                    i2 = i;
                    if (i2 != 0) {
                        Log.INSTANCE.d("Anichi", "NEED_CAPTCHA – opening episode WebView to intercept API response…");
                        String episodePageUrl10 = "https://mkissa.to/bangumi/" + this.$hash + "/p-" + this.$episode + '-' + this.$dubStatus;
                        this.L$0 = $this$coroutineScope3;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(responseText3);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(finalJson);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(episodePageUrl10);
                        this.L$5 = null;
                        this.L$6 = null;
                        this.I$0 = i2;
                        this.label = 6;
                        objShowTurnstileDialogAndWait = AnichiExtractors.INSTANCE.showTurnstileDialogAndWait(episodePageUrl10, (Continuation) this);
                        if (objShowTurnstileDialogAndWait == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        interceptedResponse = (String) objShowTurnstileDialogAndWait;
                        if (interceptedResponse == null) {
                            return Unit.INSTANCE;
                        }
                        i3 = i2;
                        responseText3 = interceptedResponse;
                    } else {
                        i3 = i2;
                    }
                    AppUtils appUtils110 = AppUtils.INSTANCE;
                    value$iv = responseText3;
                    if (value$iv == null) {
                        Result.Companion companion111112 = Result.Companion;
                        KType kTypeTypeOf110 = Reflection.typeOf(EncryptedResponse.class);
                        MagicApiIntrinsics.voidMagicApiCall(obj);
                        obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf110));
                        if (Result.exceptionOrNull-impl(obj4) == null) {
                            Result.Companion companion111113 = Result.Companion;
                            aaReq4 = finalJson;
                            obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(EncryptedResponse.class), (List) null, 2, (Object) null));
                        } else {
                            aaReq4 = finalJson;
                        }
                        if (Result.isFailure-impl(obj4)) {
                            obj6 = null;
                        } else {
                            obj6 = obj4;
                        }
                        deserializationStrategy = (KSerializer) obj6;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv114 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv114.readValue(value$iv, new TypeReference<EncryptedResponse>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$1
                            });
                        }
                        obj5 = objDecodeFromString;
                        break;
                    } else {
                        aaReq4 = finalJson;
                        obj5 = null;
                    }
                    encryptedResponse = (EncryptedResponse) obj5;
                    if (encryptedResponse != null) {
                        encryptedData = encryptedResponse.getData();
                    } else {
                        encryptedData = null;
                    }
                    if (encryptedData != null) {
                        encrypted = encryptedData.getTobeparsed();
                    } else {
                        encrypted = null;
                    }
                    if (encrypted != null) {
                        String it12 = encrypted;
                        String _mVar11 = encryptedData.get_m();
                        this.L$0 = $this$coroutineScope3;
                        this.L$1 = responseText3;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(aaReq4);
                        this.L$4 = encryptedData;
                        this.L$5 = encrypted;
                        this.L$6 = SpillingKt.nullOutSpilledVariable(it12);
                        this.I$0 = i3;
                        this.label = 7;
                        objDecodeToBeParsed = AnichiUtilsKt.decodeToBeParsed(it12, _mVar11, this);
                        if (objDecodeToBeParsed == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        String str15 = lane;
                        lane5 = encrypted;
                        obj7 = objDecodeToBeParsed;
                        lane6 = str15;
                        encryptedData2 = encryptedData;
                        encrypted = lane5;
                        aaReq5 = (String) obj7;
                        lane = lane6;
                    } else {
                        encryptedData2 = encryptedData;
                        aaReq5 = null;
                    }
                    if (aaReq5 == null) {
                    }
                    encrypted2 = encrypted;
                    if (aaReq5 == null) {
                        str3 = responseText3;
                    } else {
                        str3 = aaReq5;
                    }
                    jsonToParse = str3;
                    Log.INSTANCE.d("Phisher", jsonToParse);
                    AppUtils appUtils111 = AppUtils.INSTANCE;
                    if (jsonToParse == null) {
                        Result.Companion companion111114 = Result.Companion;
                        KType kTypeTypeOf111 = Reflection.typeOf(AnichiParser.LinksQuery.class);
                        MagicApiIntrinsics.voidMagicApiCall(obj);
                        obj8 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf111));
                        if (Result.exceptionOrNull-impl(obj8) != null) {
                            Result.Companion companion111115 = Result.Companion;
                            i4 = i3;
                            $this$coroutineScope = $this$coroutineScope3;
                            $this$coroutineScope2 = null;
                            obj8 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.LinksQuery.class), (List) null, 2, (Object) null));
                        } else {
                            i4 = i3;
                            $this$coroutineScope = $this$coroutineScope3;
                            $this$coroutineScope2 = null;
                        }
                        if (Result.isFailure-impl(obj8)) {
                            obj8 = $this$coroutineScope2;
                        }
                        deserializationStrategy2 = (KSerializer) obj8;
                        if (deserializationStrategy2 != null) {
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonToParse);
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv115 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv$iv115.readValue(jsonToParse, new TypeReference<AnichiParser.LinksQuery>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$2
                            });
                        }
                        break;
                    } else {
                        i4 = i3;
                        $this$coroutineScope = $this$coroutineScope3;
                        objDecodeFromString2 = null;
                    }
                    it = (AnichiParser.LinksQuery) objDecodeFromString2;
                    if (it != null) {
                        data = it.getData();
                        if (data != null) {
                            episode = it.getEpisode();
                            if (episode != null) {
                                sourceUrls = episode.getSourceUrls();
                            } else {
                                sourceUrls = null;
                            }
                        } else {
                            episode = it.getEpisode();
                            if (episode != null) {
                                sourceUrls = episode.getSourceUrls();
                            } else {
                                sourceUrls = null;
                            }
                        }
                        break;
                    } else {
                        sourceUrls = null;
                    }
                    if (sourceUrls == null) {
                        return Unit.INSTANCE;
                    }
                    ArrayList<AnichiParser.SourceUrls> $this$forEach$iv15 = sourceUrls;
                    function1 = this.$subtitleCallback;
                    function2 = this.$callback;
                    str2 = this.$dubStatus;
                    while (r12.hasNext()) {
                        AnichiParser.SourceUrls source15 = (AnichiParser.SourceUrls) element$iv;
                        BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source15, function1, function2, str2, null), 3, (Object) null);
                        function1 = function1;
                        function2 = function2;
                        str2 = str2;
                    }
                    return Unit.INSTANCE;
                case 5:
                    long j = this.J$0;
                    aaReq3 = (String) this.L$3;
                    lane4 = (String) this.L$2;
                    try {
                        ResultKt.throwOnFailure($result);
                        obj3 = $result;
                        obj = "kotlinx.serialization.serializer.simple";
                        str = "";
                        text3 = ((NiceResponse) obj3).getText();
                        break;
                    } catch (Exception e23) {
                        obj = "kotlinx.serialization.serializer.simple";
                        str = "";
                        text3 = str;
                        responseText3 = text3;
                        finalJson = aaReq3;
                        lane = lane4;
                        if (finalJson != null) {
                            i = 1;
                        } else {
                            i = 1;
                        }
                        i2 = i;
                        if (i2 != 0) {
                            Log.INSTANCE.d("Anichi", "NEED_CAPTCHA – opening episode WebView to intercept API response…");
                            String episodePageUrl11 = "https://mkissa.to/bangumi/" + this.$hash + "/p-" + this.$episode + '-' + this.$dubStatus;
                            this.L$0 = $this$coroutineScope3;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(responseText3);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(finalJson);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(episodePageUrl11);
                            this.L$5 = null;
                            this.L$6 = null;
                            this.I$0 = i2;
                            this.label = 6;
                            objShowTurnstileDialogAndWait = AnichiExtractors.INSTANCE.showTurnstileDialogAndWait(episodePageUrl11, (Continuation) this);
                            if (objShowTurnstileDialogAndWait == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            interceptedResponse = (String) objShowTurnstileDialogAndWait;
                            if (interceptedResponse == null) {
                                return Unit.INSTANCE;
                            }
                            i3 = i2;
                            responseText3 = interceptedResponse;
                        } else {
                            i3 = i2;
                        }
                        AppUtils appUtils112 = AppUtils.INSTANCE;
                        value$iv = responseText3;
                        if (value$iv == null) {
                            Result.Companion companion111116 = Result.Companion;
                            KType kTypeTypeOf112 = Reflection.typeOf(EncryptedResponse.class);
                            MagicApiIntrinsics.voidMagicApiCall(obj);
                            obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf112));
                            if (Result.exceptionOrNull-impl(obj4) == null) {
                                Result.Companion companion111117 = Result.Companion;
                                aaReq4 = finalJson;
                                obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(EncryptedResponse.class), (List) null, 2, (Object) null));
                            } else {
                                aaReq4 = finalJson;
                            }
                            if (Result.isFailure-impl(obj4)) {
                                obj6 = null;
                            } else {
                                obj6 = obj4;
                            }
                            deserializationStrategy = (KSerializer) obj6;
                            if (deserializationStrategy != null) {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv116 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv116.readValue(value$iv, new TypeReference<EncryptedResponse>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$1
                                });
                            }
                            obj5 = objDecodeFromString;
                            break;
                        } else {
                            aaReq4 = finalJson;
                            obj5 = null;
                        }
                        encryptedResponse = (EncryptedResponse) obj5;
                        if (encryptedResponse != null) {
                            encryptedData = encryptedResponse.getData();
                        } else {
                            encryptedData = null;
                        }
                        if (encryptedData != null) {
                            encrypted = encryptedData.getTobeparsed();
                        } else {
                            encrypted = null;
                        }
                        if (encrypted != null) {
                            String it13 = encrypted;
                            String _mVar12 = encryptedData.get_m();
                            this.L$0 = $this$coroutineScope3;
                            this.L$1 = responseText3;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(aaReq4);
                            this.L$4 = encryptedData;
                            this.L$5 = encrypted;
                            this.L$6 = SpillingKt.nullOutSpilledVariable(it13);
                            this.I$0 = i3;
                            this.label = 7;
                            objDecodeToBeParsed = AnichiUtilsKt.decodeToBeParsed(it13, _mVar12, this);
                            if (objDecodeToBeParsed == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            String str16 = lane;
                            lane5 = encrypted;
                            obj7 = objDecodeToBeParsed;
                            lane6 = str16;
                            encryptedData2 = encryptedData;
                            encrypted = lane5;
                            aaReq5 = (String) obj7;
                            lane = lane6;
                        } else {
                            encryptedData2 = encryptedData;
                            aaReq5 = null;
                        }
                        if (aaReq5 == null) {
                        }
                        encrypted2 = encrypted;
                        if (aaReq5 == null) {
                            str3 = responseText3;
                        } else {
                            str3 = aaReq5;
                        }
                        jsonToParse = str3;
                        Log.INSTANCE.d("Phisher", jsonToParse);
                        AppUtils appUtils113 = AppUtils.INSTANCE;
                        if (jsonToParse == null) {
                            Result.Companion companion111118 = Result.Companion;
                            KType kTypeTypeOf113 = Reflection.typeOf(AnichiParser.LinksQuery.class);
                            MagicApiIntrinsics.voidMagicApiCall(obj);
                            obj8 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf113));
                            if (Result.exceptionOrNull-impl(obj8) != null) {
                                Result.Companion companion111119 = Result.Companion;
                                i4 = i3;
                                $this$coroutineScope = $this$coroutineScope3;
                                $this$coroutineScope2 = null;
                                obj8 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.LinksQuery.class), (List) null, 2, (Object) null));
                            } else {
                                i4 = i3;
                                $this$coroutineScope = $this$coroutineScope3;
                                $this$coroutineScope2 = null;
                            }
                            if (Result.isFailure-impl(obj8)) {
                                obj8 = $this$coroutineScope2;
                            }
                            deserializationStrategy2 = (KSerializer) obj8;
                            if (deserializationStrategy2 != null) {
                                objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonToParse);
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv117 = MainAPIKt.getMapper();
                                objDecodeFromString2 = $this$readValue$iv$iv$iv117.readValue(jsonToParse, new TypeReference<AnichiParser.LinksQuery>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$2
                                });
                            }
                            break;
                        } else {
                            i4 = i3;
                            $this$coroutineScope = $this$coroutineScope3;
                            objDecodeFromString2 = null;
                        }
                        it = (AnichiParser.LinksQuery) objDecodeFromString2;
                        if (it != null) {
                            data = it.getData();
                            if (data != null) {
                                episode = it.getEpisode();
                                if (episode != null) {
                                    sourceUrls = episode.getSourceUrls();
                                } else {
                                    sourceUrls = null;
                                }
                            } else {
                                episode = it.getEpisode();
                                if (episode != null) {
                                    sourceUrls = episode.getSourceUrls();
                                } else {
                                    sourceUrls = null;
                                }
                            }
                            break;
                        } else {
                            sourceUrls = null;
                        }
                        if (sourceUrls == null) {
                            return Unit.INSTANCE;
                        }
                        ArrayList<AnichiParser.SourceUrls> $this$forEach$iv16 = sourceUrls;
                        function1 = this.$subtitleCallback;
                        function2 = this.$callback;
                        str2 = this.$dubStatus;
                        while (r12.hasNext()) {
                            AnichiParser.SourceUrls source16 = (AnichiParser.SourceUrls) element$iv;
                            BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source16, function1, function2, str2, null), 3, (Object) null);
                            function1 = function1;
                            function2 = function2;
                            str2 = str2;
                        }
                        return Unit.INSTANCE;
                    }
                    responseText3 = text3;
                    finalJson = aaReq3;
                    lane = lane4;
                    if (finalJson != null) {
                        i = 1;
                    } else {
                        i = 1;
                    }
                    i2 = i;
                    if (i2 != 0) {
                        Log.INSTANCE.d("Anichi", "NEED_CAPTCHA – opening episode WebView to intercept API response…");
                        String episodePageUrl12 = "https://mkissa.to/bangumi/" + this.$hash + "/p-" + this.$episode + '-' + this.$dubStatus;
                        this.L$0 = $this$coroutineScope3;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(responseText3);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(finalJson);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(episodePageUrl12);
                        this.L$5 = null;
                        this.L$6 = null;
                        this.I$0 = i2;
                        this.label = 6;
                        objShowTurnstileDialogAndWait = AnichiExtractors.INSTANCE.showTurnstileDialogAndWait(episodePageUrl12, (Continuation) this);
                        if (objShowTurnstileDialogAndWait == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        interceptedResponse = (String) objShowTurnstileDialogAndWait;
                        if (interceptedResponse == null) {
                            return Unit.INSTANCE;
                        }
                        i3 = i2;
                        responseText3 = interceptedResponse;
                    } else {
                        i3 = i2;
                    }
                    AppUtils appUtils114 = AppUtils.INSTANCE;
                    value$iv = responseText3;
                    if (value$iv == null) {
                        Result.Companion companion1111110 = Result.Companion;
                        KType kTypeTypeOf114 = Reflection.typeOf(EncryptedResponse.class);
                        MagicApiIntrinsics.voidMagicApiCall(obj);
                        obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf114));
                        if (Result.exceptionOrNull-impl(obj4) == null) {
                            Result.Companion companion1111111 = Result.Companion;
                            aaReq4 = finalJson;
                            obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(EncryptedResponse.class), (List) null, 2, (Object) null));
                        } else {
                            aaReq4 = finalJson;
                        }
                        if (Result.isFailure-impl(obj4)) {
                            obj6 = null;
                        } else {
                            obj6 = obj4;
                        }
                        deserializationStrategy = (KSerializer) obj6;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv118 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv118.readValue(value$iv, new TypeReference<EncryptedResponse>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$1
                            });
                        }
                        obj5 = objDecodeFromString;
                        break;
                    } else {
                        aaReq4 = finalJson;
                        obj5 = null;
                    }
                    encryptedResponse = (EncryptedResponse) obj5;
                    if (encryptedResponse != null) {
                        encryptedData = encryptedResponse.getData();
                    } else {
                        encryptedData = null;
                    }
                    if (encryptedData != null) {
                        encrypted = encryptedData.getTobeparsed();
                    } else {
                        encrypted = null;
                    }
                    if (encrypted != null) {
                        String it14 = encrypted;
                        String _mVar13 = encryptedData.get_m();
                        this.L$0 = $this$coroutineScope3;
                        this.L$1 = responseText3;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(aaReq4);
                        this.L$4 = encryptedData;
                        this.L$5 = encrypted;
                        this.L$6 = SpillingKt.nullOutSpilledVariable(it14);
                        this.I$0 = i3;
                        this.label = 7;
                        objDecodeToBeParsed = AnichiUtilsKt.decodeToBeParsed(it14, _mVar13, this);
                        if (objDecodeToBeParsed == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        String str17 = lane;
                        lane5 = encrypted;
                        obj7 = objDecodeToBeParsed;
                        lane6 = str17;
                        encryptedData2 = encryptedData;
                        encrypted = lane5;
                        aaReq5 = (String) obj7;
                        lane = lane6;
                    } else {
                        encryptedData2 = encryptedData;
                        aaReq5 = null;
                    }
                    if (aaReq5 == null) {
                    }
                    encrypted2 = encrypted;
                    if (aaReq5 == null) {
                        str3 = responseText3;
                    } else {
                        str3 = aaReq5;
                    }
                    jsonToParse = str3;
                    Log.INSTANCE.d("Phisher", jsonToParse);
                    AppUtils appUtils115 = AppUtils.INSTANCE;
                    if (jsonToParse == null) {
                        Result.Companion companion1111112 = Result.Companion;
                        KType kTypeTypeOf115 = Reflection.typeOf(AnichiParser.LinksQuery.class);
                        MagicApiIntrinsics.voidMagicApiCall(obj);
                        obj8 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf115));
                        if (Result.exceptionOrNull-impl(obj8) != null) {
                            Result.Companion companion1111113 = Result.Companion;
                            i4 = i3;
                            $this$coroutineScope = $this$coroutineScope3;
                            $this$coroutineScope2 = null;
                            obj8 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.LinksQuery.class), (List) null, 2, (Object) null));
                        } else {
                            i4 = i3;
                            $this$coroutineScope = $this$coroutineScope3;
                            $this$coroutineScope2 = null;
                        }
                        if (Result.isFailure-impl(obj8)) {
                            obj8 = $this$coroutineScope2;
                        }
                        deserializationStrategy2 = (KSerializer) obj8;
                        if (deserializationStrategy2 != null) {
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonToParse);
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv119 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv$iv119.readValue(jsonToParse, new TypeReference<AnichiParser.LinksQuery>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$2
                            });
                        }
                        break;
                    } else {
                        i4 = i3;
                        $this$coroutineScope = $this$coroutineScope3;
                        objDecodeFromString2 = null;
                    }
                    it = (AnichiParser.LinksQuery) objDecodeFromString2;
                    if (it != null) {
                        data = it.getData();
                        if (data != null) {
                            episode = it.getEpisode();
                            if (episode != null) {
                                sourceUrls = episode.getSourceUrls();
                            } else {
                                sourceUrls = null;
                            }
                        } else {
                            episode = it.getEpisode();
                            if (episode != null) {
                                sourceUrls = episode.getSourceUrls();
                            } else {
                                sourceUrls = null;
                            }
                        }
                        break;
                    } else {
                        sourceUrls = null;
                    }
                    if (sourceUrls == null) {
                        return Unit.INSTANCE;
                    }
                    ArrayList<AnichiParser.SourceUrls> $this$forEach$iv17 = sourceUrls;
                    function1 = this.$subtitleCallback;
                    function2 = this.$callback;
                    str2 = this.$dubStatus;
                    while (r12.hasNext()) {
                        AnichiParser.SourceUrls source17 = (AnichiParser.SourceUrls) element$iv;
                        BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source17, function1, function2, str2, null), 3, (Object) null);
                        function1 = function1;
                        function2 = function2;
                        str2 = str2;
                    }
                    return Unit.INSTANCE;
                case 6:
                    i2 = this.I$0;
                    finalJson = (String) this.L$3;
                    lane = (String) this.L$2;
                    responseText3 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    obj = "kotlinx.serialization.serializer.simple";
                    objShowTurnstileDialogAndWait = $result;
                    interceptedResponse = (String) objShowTurnstileDialogAndWait;
                    if (interceptedResponse == null) {
                        return Unit.INSTANCE;
                    }
                    i3 = i2;
                    responseText3 = interceptedResponse;
                    AppUtils appUtils116 = AppUtils.INSTANCE;
                    value$iv = responseText3;
                    if (value$iv == null) {
                        Result.Companion companion1111114 = Result.Companion;
                        KType kTypeTypeOf116 = Reflection.typeOf(EncryptedResponse.class);
                        MagicApiIntrinsics.voidMagicApiCall(obj);
                        obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf116));
                        if (Result.exceptionOrNull-impl(obj4) == null) {
                            Result.Companion companion1111115 = Result.Companion;
                            aaReq4 = finalJson;
                            obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(EncryptedResponse.class), (List) null, 2, (Object) null));
                        } else {
                            aaReq4 = finalJson;
                        }
                        if (Result.isFailure-impl(obj4)) {
                            obj6 = null;
                        } else {
                            obj6 = obj4;
                        }
                        deserializationStrategy = (KSerializer) obj6;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv1110 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv1110.readValue(value$iv, new TypeReference<EncryptedResponse>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$1
                            });
                        }
                        obj5 = objDecodeFromString;
                        break;
                    } else {
                        aaReq4 = finalJson;
                        obj5 = null;
                    }
                    encryptedResponse = (EncryptedResponse) obj5;
                    if (encryptedResponse != null) {
                        encryptedData = encryptedResponse.getData();
                    } else {
                        encryptedData = null;
                    }
                    if (encryptedData != null) {
                        encrypted = encryptedData.getTobeparsed();
                    } else {
                        encrypted = null;
                    }
                    if (encrypted != null) {
                        String it15 = encrypted;
                        String _mVar14 = encryptedData.get_m();
                        this.L$0 = $this$coroutineScope3;
                        this.L$1 = responseText3;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(lane);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(aaReq4);
                        this.L$4 = encryptedData;
                        this.L$5 = encrypted;
                        this.L$6 = SpillingKt.nullOutSpilledVariable(it15);
                        this.I$0 = i3;
                        this.label = 7;
                        objDecodeToBeParsed = AnichiUtilsKt.decodeToBeParsed(it15, _mVar14, this);
                        if (objDecodeToBeParsed == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        String str18 = lane;
                        lane5 = encrypted;
                        obj7 = objDecodeToBeParsed;
                        lane6 = str18;
                        encryptedData2 = encryptedData;
                        encrypted = lane5;
                        aaReq5 = (String) obj7;
                        lane = lane6;
                    } else {
                        encryptedData2 = encryptedData;
                        aaReq5 = null;
                    }
                    if (aaReq5 == null) {
                    }
                    encrypted2 = encrypted;
                    if (aaReq5 == null) {
                        str3 = responseText3;
                    } else {
                        str3 = aaReq5;
                    }
                    jsonToParse = str3;
                    Log.INSTANCE.d("Phisher", jsonToParse);
                    AppUtils appUtils117 = AppUtils.INSTANCE;
                    if (jsonToParse == null) {
                        Result.Companion companion1111116 = Result.Companion;
                        KType kTypeTypeOf117 = Reflection.typeOf(AnichiParser.LinksQuery.class);
                        MagicApiIntrinsics.voidMagicApiCall(obj);
                        obj8 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf117));
                        if (Result.exceptionOrNull-impl(obj8) != null) {
                            Result.Companion companion1111117 = Result.Companion;
                            i4 = i3;
                            $this$coroutineScope = $this$coroutineScope3;
                            $this$coroutineScope2 = null;
                            obj8 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.LinksQuery.class), (List) null, 2, (Object) null));
                        } else {
                            i4 = i3;
                            $this$coroutineScope = $this$coroutineScope3;
                            $this$coroutineScope2 = null;
                        }
                        if (Result.isFailure-impl(obj8)) {
                            obj8 = $this$coroutineScope2;
                        }
                        deserializationStrategy2 = (KSerializer) obj8;
                        if (deserializationStrategy2 != null) {
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonToParse);
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv1111 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv$iv1111.readValue(jsonToParse, new TypeReference<AnichiParser.LinksQuery>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$2
                            });
                        }
                        break;
                    } else {
                        i4 = i3;
                        $this$coroutineScope = $this$coroutineScope3;
                        objDecodeFromString2 = null;
                    }
                    it = (AnichiParser.LinksQuery) objDecodeFromString2;
                    if (it != null) {
                        data = it.getData();
                        if (data != null) {
                            episode = it.getEpisode();
                            if (episode != null) {
                                sourceUrls = episode.getSourceUrls();
                            } else {
                                sourceUrls = null;
                            }
                        } else {
                            episode = it.getEpisode();
                            if (episode != null) {
                                sourceUrls = episode.getSourceUrls();
                            } else {
                                sourceUrls = null;
                            }
                        }
                        break;
                    } else {
                        sourceUrls = null;
                    }
                    if (sourceUrls == null) {
                        return Unit.INSTANCE;
                    }
                    ArrayList<AnichiParser.SourceUrls> $this$forEach$iv18 = sourceUrls;
                    function1 = this.$subtitleCallback;
                    function2 = this.$callback;
                    str2 = this.$dubStatus;
                    while (r12.hasNext()) {
                        AnichiParser.SourceUrls source18 = (AnichiParser.SourceUrls) element$iv;
                        BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source18, function1, function2, str2, null), 3, (Object) null);
                        function1 = function1;
                        function2 = function2;
                        str2 = str2;
                    }
                    return Unit.INSTANCE;
                case 7:
                    i3 = this.I$0;
                    lane5 = (String) this.L$5;
                    EncryptedData encryptedData3 = (EncryptedData) this.L$4;
                    String aaReq8 = (String) this.L$3;
                    lane6 = (String) this.L$2;
                    String responseText8 = (String) this.L$1;
                    try {
                        ResultKt.throwOnFailure($result);
                        obj = "kotlinx.serialization.serializer.simple";
                        encryptedData2 = encryptedData3;
                        aaReq4 = aaReq8;
                        responseText3 = responseText8;
                        obj7 = $result;
                        encrypted = lane5;
                        aaReq5 = (String) obj7;
                        lane = lane6;
                        if (aaReq5 == null) {
                        }
                        encrypted2 = encrypted;
                        if (aaReq5 == null) {
                            str3 = responseText3;
                        } else {
                            str3 = aaReq5;
                        }
                        jsonToParse = str3;
                        Log.INSTANCE.d("Phisher", jsonToParse);
                        AppUtils appUtils118 = AppUtils.INSTANCE;
                        if (jsonToParse == null) {
                            i4 = i3;
                            $this$coroutineScope = $this$coroutineScope3;
                            objDecodeFromString2 = null;
                        } else {
                            Result.Companion companion1111118 = Result.Companion;
                            KType kTypeTypeOf118 = Reflection.typeOf(AnichiParser.LinksQuery.class);
                            MagicApiIntrinsics.voidMagicApiCall(obj);
                            obj8 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf118));
                            if (Result.exceptionOrNull-impl(obj8) != null) {
                                Result.Companion companion1111119 = Result.Companion;
                                i4 = i3;
                                $this$coroutineScope = $this$coroutineScope3;
                                $this$coroutineScope2 = null;
                                obj8 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.LinksQuery.class), (List) null, 2, (Object) null));
                            } else {
                                i4 = i3;
                                $this$coroutineScope = $this$coroutineScope3;
                                $this$coroutineScope2 = null;
                            }
                            if (Result.isFailure-impl(obj8)) {
                                obj8 = $this$coroutineScope2;
                            }
                            deserializationStrategy2 = (KSerializer) obj8;
                            if (deserializationStrategy2 != null) {
                                objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonToParse);
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv1112 = MainAPIKt.getMapper();
                                objDecodeFromString2 = $this$readValue$iv$iv$iv1112.readValue(jsonToParse, new TypeReference<AnichiParser.LinksQuery>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$2
                                });
                            }
                        }
                        it = (AnichiParser.LinksQuery) objDecodeFromString2;
                        if (it != null) {
                            data = it.getData();
                            if (data != null) {
                                episode = it.getEpisode();
                                if (episode != null) {
                                    sourceUrls = episode.getSourceUrls();
                                } else {
                                    sourceUrls = null;
                                }
                            } else {
                                episode = it.getEpisode();
                                if (episode != null) {
                                    sourceUrls = episode.getSourceUrls();
                                } else {
                                    sourceUrls = null;
                                }
                            }
                        } else {
                            sourceUrls = null;
                        }
                        break;
                    } catch (Exception e24) {
                        e = e24;
                        $this$coroutineScope = $this$coroutineScope3;
                        finalJson = aaReq8;
                        lane = lane6;
                        e.printStackTrace();
                        sourceUrls = null;
                        if (sourceUrls == null) {
                            return Unit.INSTANCE;
                        }
                        ArrayList<AnichiParser.SourceUrls> $this$forEach$iv19 = sourceUrls;
                        function1 = this.$subtitleCallback;
                        function2 = this.$callback;
                        str2 = this.$dubStatus;
                        while (r12.hasNext()) {
                            AnichiParser.SourceUrls source19 = (AnichiParser.SourceUrls) element$iv;
                            BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source19, function1, function2, str2, null), 3, (Object) null);
                            function1 = function1;
                            function2 = function2;
                            str2 = str2;
                        }
                        return Unit.INSTANCE;
                    }
                    if (sourceUrls == null) {
                        return Unit.INSTANCE;
                    }
                    ArrayList<AnichiParser.SourceUrls> $this$forEach$iv110 = sourceUrls;
                    function1 = this.$subtitleCallback;
                    function2 = this.$callback;
                    str2 = this.$dubStatus;
                    while (r12.hasNext()) {
                        AnichiParser.SourceUrls source110 = (AnichiParser.SourceUrls) element$iv;
                        BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source110, function1, function2, str2, null), 3, (Object) null);
                        function1 = function1;
                        function2 = function2;
                        str2 = str2;
                    }
                    return Unit.INSTANCE;
                case 8:
                    i3 = this.I$0;
                    encrypted2 = (String) this.L$5;
                    finalJson = (String) this.L$3;
                    lane = (String) this.L$2;
                    responseText3 = (String) this.L$1;
                    try {
                        ResultKt.throwOnFailure($result);
                        obj = "kotlinx.serialization.serializer.simple";
                        objDecodeToBeParsed2 = $result;
                        aaReq4 = finalJson;
                        aaReq5 = (String) objDecodeToBeParsed2;
                        if (aaReq5 == null) {
                            str3 = responseText3;
                        } else {
                            str3 = aaReq5;
                        }
                        jsonToParse = str3;
                        Log.INSTANCE.d("Phisher", jsonToParse);
                        AppUtils appUtils119 = AppUtils.INSTANCE;
                        if (jsonToParse == null) {
                            i4 = i3;
                            $this$coroutineScope = $this$coroutineScope3;
                            objDecodeFromString2 = null;
                        } else {
                            Result.Companion companion11111110 = Result.Companion;
                            KType kTypeTypeOf119 = Reflection.typeOf(AnichiParser.LinksQuery.class);
                            MagicApiIntrinsics.voidMagicApiCall(obj);
                            obj8 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf119));
                            if (Result.exceptionOrNull-impl(obj8) != null) {
                                Result.Companion companion11111111 = Result.Companion;
                                i4 = i3;
                                $this$coroutineScope = $this$coroutineScope3;
                                $this$coroutineScope2 = null;
                                obj8 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.LinksQuery.class), (List) null, 2, (Object) null));
                            } else {
                                i4 = i3;
                                $this$coroutineScope = $this$coroutineScope3;
                                $this$coroutineScope2 = null;
                            }
                            if (Result.isFailure-impl(obj8)) {
                                obj8 = $this$coroutineScope2;
                            }
                            deserializationStrategy2 = (KSerializer) obj8;
                            if (deserializationStrategy2 != null) {
                                objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, jsonToParse);
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv1113 = MainAPIKt.getMapper();
                                objDecodeFromString2 = $this$readValue$iv$iv$iv1113.readValue(jsonToParse, new TypeReference<AnichiParser.LinksQuery>() { // from class: com.Anichi.AnichiExtractors$invokeInternalSources$2$invokeSuspend$$inlined$tryParseJson$2
                                });
                            }
                        }
                        it = (AnichiParser.LinksQuery) objDecodeFromString2;
                        if (it != null) {
                            data = it.getData();
                            if (data != null) {
                                episode = it.getEpisode();
                                if (episode != null) {
                                    sourceUrls = episode.getSourceUrls();
                                } else {
                                    sourceUrls = null;
                                }
                            } else {
                                episode = it.getEpisode();
                                if (episode != null) {
                                    sourceUrls = episode.getSourceUrls();
                                } else {
                                    sourceUrls = null;
                                }
                            }
                        } else {
                            sourceUrls = null;
                        }
                        break;
                    } catch (Exception e25) {
                        e = e25;
                        $this$coroutineScope = $this$coroutineScope3;
                        e.printStackTrace();
                        sourceUrls = null;
                        if (sourceUrls == null) {
                            return Unit.INSTANCE;
                        }
                        ArrayList<AnichiParser.SourceUrls> $this$forEach$iv111 = sourceUrls;
                        function1 = this.$subtitleCallback;
                        function2 = this.$callback;
                        str2 = this.$dubStatus;
                        while (r12.hasNext()) {
                            AnichiParser.SourceUrls source111 = (AnichiParser.SourceUrls) element$iv;
                            BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source111, function1, function2, str2, null), 3, (Object) null);
                            function1 = function1;
                            function2 = function2;
                            str2 = str2;
                        }
                        return Unit.INSTANCE;
                    }
                    if (sourceUrls == null) {
                        return Unit.INSTANCE;
                    }
                    ArrayList<AnichiParser.SourceUrls> $this$forEach$iv112 = sourceUrls;
                    function1 = this.$subtitleCallback;
                    function2 = this.$callback;
                    str2 = this.$dubStatus;
                    while (r12.hasNext()) {
                        AnichiParser.SourceUrls source112 = (AnichiParser.SourceUrls) element$iv;
                        BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnichiExtractors$invokeInternalSources$2$4$1(source112, function1, function2, str2, null), 3, (Object) null);
                        function1 = function1;
                        function2 = function2;
                        str2 = str2;
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Nullable
    public final Object invokeInternalSources(@NotNull String hash, @NotNull String dubStatus, @NotNull String episode, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C00102(hash, dubStatus, episode, function1, function2, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String decrypthex(String inputStr) {
        String hexString;
        if (StringsKt.startsWith$default(inputStr, "-", false, 2, (Object) null)) {
            hexString = StringsKt.substringAfterLast$default(inputStr, "-", (String) null, 2, (Object) null);
        } else {
            hexString = inputStr;
        }
        int length = hexString.length() / 2;
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            String hexByte = hexString.substring(i2, i2 + 2);
            Intrinsics.checkNotNullExpressionValue(hexByte, "substring(...)");
            bytes[i] = (byte) (Integer.parseInt(hexByte, CharsKt.checkRadix(16)) ^ 56);
        }
        return StringsKt.decodeToString(bytes);
    }
}
