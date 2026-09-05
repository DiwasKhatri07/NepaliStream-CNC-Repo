package com.cncverse.M3UPlaylistPlayer;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.plugins.Plugin;
import com.lagradost.cloudstream3.utils.AppUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: M3UPlaylistPlayerPlugin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/M3UPlaylistPlayerProvider/CNCVerse/java/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/cncverse/M3UPlaylistPlayer/M3UPlaylistPlayerPlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "sharedPref", "Landroid/content/SharedPreferences;", "load", "", "context", "Landroid/content/Context;", "M3UPlaylistPlayerProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nM3UPlaylistPlayerPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 M3UPlaylistPlayerPlugin.kt\ncom/cncverse/M3UPlaylistPlayer/M3UPlaylistPlayerPlugin\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,46:1\n63#2:47\n64#2,15:49\n1#3:48\n50#4:64\n43#4:65\n1915#5,2:66\n*S KotlinDebug\n*F\n+ 1 M3UPlaylistPlayerPlugin.kt\ncom/cncverse/M3UPlaylistPlayer/M3UPlaylistPlayerPlugin\n*L\n20#1:47\n20#1:49,15\n20#1:48\n20#1:64\n20#1:65\n26#1:66,2\n*E\n"})
public final class M3UPlaylistPlayerPlugin extends Plugin {

    @Nullable
    private final SharedPreferences sharedPref;

    public M3UPlaylistPlayerPlugin() {
        Activity activity = CommonActivity.INSTANCE.getActivity();
        this.sharedPref = activity != null ? activity.getSharedPreferences("M3UPlaylistPlayerPrefs", 0) : null;
    }

    public void load(@NotNull Context context) {
        final List playlists;
        Object obj;
        Object objDecodeFromString;
        String string;
        M3UPlaylistPlayer.INSTANCE.setContext(context);
        SharedPreferences sharedPreferences = this.sharedPref;
        String playlistsJson = "[]";
        if (sharedPreferences != null && (string = sharedPreferences.getString("playlists", "[]")) != null) {
            playlistsJson = string;
        }
        try {
            AppUtils appUtils = AppUtils.INSTANCE;
            String value$iv = playlistsJson;
            try {
                Result.Companion companion = Result.Companion;
                KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PlaylistEntry.class)));
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.exceptionOrNull-impl(obj) != null) {
                try {
                    Result.Companion companion3 = Result.Companion;
                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th2));
                }
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            DeserializationStrategy deserializationStrategy = (KSerializer) obj;
            if (deserializationStrategy != null) {
                try {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                } catch (SerializationException e) {
                    ArchComponentExtKt.logError(e);
                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv.readValue(value$iv, new TypeReference<List<? extends PlaylistEntry>>() { // from class: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayerPlugin$load$$inlined$parseJson$1
                    });
                } catch (Throwable th3) {
                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv2.readValue(value$iv, new TypeReference<List<? extends PlaylistEntry>>() { // from class: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayerPlugin$load$$inlined$parseJson$1
                    });
                }
                playlists = (List) objDecodeFromString;
            } else {
                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv3.readValue(value$iv, new TypeReference<List<? extends PlaylistEntry>>() { // from class: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayerPlugin$load$$inlined$parseJson$1
                });
                playlists = (List) objDecodeFromString;
            }
        } catch (Exception e2) {
            playlists = CollectionsKt.emptyList();
        }
        Iterable $this$forEach$iv = playlists;
        for (Object element$iv : $this$forEach$iv) {
            PlaylistEntry playlist = (PlaylistEntry) element$iv;
            if (!StringsKt.isBlank(playlist.getName()) && !StringsKt.isBlank(playlist.getUrl())) {
                registerMainAPI(new M3UPlaylistPlayer(playlist.getName(), playlist.getUrl()));
            }
        }
        final AppCompatActivity activity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        setOpenSettings(new Function1() { // from class: com.cncverse.M3UPlaylistPlayer.M3UPlaylistPlayerPlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj2) {
                return M3UPlaylistPlayerPlugin.load$lambda$1(activity, this, playlists, (Context) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$1(AppCompatActivity $activity, M3UPlaylistPlayerPlugin this$0, List $playlists, Context it) {
        if ($activity != null) {
            Settings frag = new Settings(this$0, this$0.sharedPref, $playlists);
            frag.show($activity.getSupportFragmentManager(), "M3UPlaylistPlayerSettings");
        }
        return Unit.INSTANCE;
    }
}
