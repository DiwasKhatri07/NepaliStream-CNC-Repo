package com.phisher98;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainActivity;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.plugins.Plugin;
import com.lagradost.cloudstream3.plugins.PluginData;
import com.lagradost.cloudstream3.plugins.PluginManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: StremioXPlugin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StremioX/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000Ê\u0001\u0002\b\u000e¨\u0006\r"}, d2 = {"Lcom/phisher98/StremioXPlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "PREF_FILE", "", "PREF_KEY_LINKS", "load", "", "context", "Landroid/content/Context;", "reload", "LinkEntry", "StremioX", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@CloudstreamPlugin
@SourceDebugExtension({"SMAP\nStremioXPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StremioXPlugin.kt\ncom/phisher98/StremioXPlugin\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,108:1\n1#2:109\n*E\n"})
public final class StremioXPlugin extends Plugin {

    @NotNull
    private final String PREF_FILE = "StremioX";

    @NotNull
    private final String PREF_KEY_LINKS = "stremio_saved_links";

    public void load(@NotNull final Context context) {
        try {
            registerMainAPI((MainAPI) new StremioX("", "StremioX"));
        } catch (Throwable th) {
        }
        try {
            registerMainAPI(new StremioC("", "StremioC"));
        } catch (Throwable th2) {
        }
        reload(context);
        final AppCompatActivity activity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        setOpenSettings(new Function1() { // from class: com.phisher98.StremioXPlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return StremioXPlugin.load$lambda$0(this.f$0, context, activity, (Context) obj);
            }
        });
    }

    static final Unit load$lambda$0(StremioXPlugin this$0, Context $context, AppCompatActivity $activity, Context it) {
        FragmentManager fm;
        SettingsBottomFragment frag = new SettingsBottomFragment(this$0, $context.getSharedPreferences(this$0.PREF_FILE, 0));
        if ($activity != null && (fm = $activity.getSupportFragmentManager()) != null) {
            frag.show(fm, "Frag");
        }
        return Unit.INSTANCE;
    }

    public final void reload(@NotNull Context context) {
        PluginData found;
        try {
            SharedPreferences prefs = context.getSharedPreferences(this.PREF_FILE, 0);
            String string = prefs.getString(this.PREF_KEY_LINKS, null);
            if (string == null) {
                string = "[]";
            }
            String json = string;
            JSONArray arr = new JSONArray(json);
            List links = new ArrayList();
            int length = arr.length();
            for (int i = 0; i < length; i++) {
                JSONObject obj = arr.optJSONObject(i);
                if (obj != null) {
                    links.add(new LinkEntry(obj.optLong("id", System.currentTimeMillis()), obj.optString("name", ""), obj.optString("link", ""), obj.optString("type", "StremioX")));
                }
            }
            Iterator it = links.iterator();
            while (it.hasNext()) {
                LinkEntry item = (LinkEntry) it.next();
                PluginData[] pluginsOnline = PluginManager.INSTANCE.getPluginsOnline();
                PluginData found2 = null;
                int length2 = pluginsOnline.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        found = found2;
                        it = it;
                        break;
                    }
                    PluginData p = pluginsOnline[i2];
                    PluginData found3 = found2;
                    it = it;
                    if (!StringsKt.contains(p.getInternalName(), item.getName(), true)) {
                        i2++;
                        it = it;
                        found2 = found3;
                    } else {
                        found = p;
                        break;
                    }
                }
                if (found != null) {
                    try {
                        PluginManager.INSTANCE.unloadPlugin(found.getFilePath());
                    } catch (Throwable e) {
                        Log.INSTANCE.e("StremioXPlugin", "unload failed " + e.getMessage());
                    }
                } else {
                    try {
                        String type = item.getType();
                        if (Intrinsics.areEqual(type, "StremioX")) {
                            try {
                                registerMainAPI((MainAPI) new StremioX(item.getLink(), item.getName()));
                            } catch (Throwable th) {
                                registerMainAPI((MainAPI) new StremioX("", item.getName()));
                            }
                        } else if (Intrinsics.areEqual(type, "StremioC")) {
                            try {
                                registerMainAPI(new StremioC(item.getLink(), item.getName()));
                            } catch (Throwable th2) {
                                registerMainAPI(new StremioC("", item.getName()));
                            }
                        } else {
                            try {
                                registerMainAPI((MainAPI) new StremioX(item.getLink(), item.getName()));
                            } catch (Throwable th3) {
                            }
                        }
                    } catch (Throwable e2) {
                        Log.INSTANCE.e("StremioXPlugin", "register failed " + e2.getMessage());
                    }
                }
            }
            try {
                MainActivity.Companion.getAfterPluginsLoadedEvent().invoke(true);
            } catch (Throwable e3) {
                Log.INSTANCE.w("StremioXPlugin", "afterPluginsLoaded invoke failed " + e3.getMessage());
            }
        } catch (Throwable e4) {
            Log.INSTANCE.e("StremioXPlugin", "reload error " + e4.getMessage());
        }
    }

    /* JADX INFO: compiled from: StremioXPlugin.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/phisher98/StremioXPlugin$LinkEntry;", "", "id", "", "name", "", "link", "type", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getLink", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LinkEntry {
        private final long id;

        @NotNull
        private final String link;

        @NotNull
        private final String name;

        @NotNull
        private final String type;

        public static /* synthetic */ LinkEntry copy$default(LinkEntry linkEntry, long j, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                j = linkEntry.id;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = linkEntry.name;
            }
            String str4 = str;
            if ((i & 4) != 0) {
                str2 = linkEntry.link;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                str3 = linkEntry.type;
            }
            return linkEntry.copy(j2, str4, str5, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getId() {
            return this.id;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getLink() {
            return this.link;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final LinkEntry copy(long id, @NotNull String name, @NotNull String link, @NotNull String type) {
            return new LinkEntry(id, name, link, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkEntry)) {
                return false;
            }
            LinkEntry linkEntry = (LinkEntry) other;
            return this.id == linkEntry.id && Intrinsics.areEqual(this.name, linkEntry.name) && Intrinsics.areEqual(this.link, linkEntry.link) && Intrinsics.areEqual(this.type, linkEntry.type);
        }

        public int hashCode() {
            return (((((StremioXPlugin$LinkEntry$$ExternalSyntheticBackport0.m2m(this.id) * 31) + this.name.hashCode()) * 31) + this.link.hashCode()) * 31) + this.type.hashCode();
        }

        @NotNull
        public String toString() {
            return "LinkEntry(id=" + this.id + ", name=" + this.name + ", link=" + this.link + ", type=" + this.type + ')';
        }

        public LinkEntry(long id, @NotNull String name, @NotNull String link, @NotNull String type) {
            this.id = id;
            this.name = name;
            this.link = link;
            this.type = type;
        }

        public final long getId() {
            return this.id;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getLink() {
            return this.link;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }
}
