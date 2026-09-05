package com.phisher98;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: XDMoviesParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/XDMovies/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J>\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR'\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR'\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006!"}, d2 = {"Lcom/phisher98/Network;", "", "id", "", "logoPath", "", "name", "originCountry", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLogoPath", "()Ljava/lang/String;", "Lcom/google/gson/annotations/SerializedName;", "value", "logo_path", "getName", "getOriginCountry", "origin_country", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/Network;", "equals", "", "other", "hashCode", "", "toString", "XDMovies"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Network {

    @Nullable
    private final Long id;

    @SerializedName("logo_path")
    @Nullable
    private final String logoPath;

    @Nullable
    private final String name;

    @SerializedName("origin_country")
    @Nullable
    private final String originCountry;

    public Network() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ Network copy$default(Network network, Long l, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            l = network.id;
        }
        if ((i & 2) != 0) {
            str = network.logoPath;
        }
        if ((i & 4) != 0) {
            str2 = network.name;
        }
        if ((i & 8) != 0) {
            str3 = network.originCountry;
        }
        return network.copy(l, str, str2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLogoPath() {
        return this.logoPath;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOriginCountry() {
        return this.originCountry;
    }

    @NotNull
    public final Network copy(@Nullable Long id, @Nullable String logoPath, @Nullable String name, @Nullable String originCountry) {
        return new Network(id, logoPath, name, originCountry);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Network)) {
            return false;
        }
        Network network = (Network) other;
        return Intrinsics.areEqual(this.id, network.id) && Intrinsics.areEqual(this.logoPath, network.logoPath) && Intrinsics.areEqual(this.name, network.name) && Intrinsics.areEqual(this.originCountry, network.originCountry);
    }

    public int hashCode() {
        return ((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.logoPath == null ? 0 : this.logoPath.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.originCountry != null ? this.originCountry.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Network(id=" + this.id + ", logoPath=" + this.logoPath + ", name=" + this.name + ", originCountry=" + this.originCountry + ')';
    }

    public Network(@Nullable Long id, @Nullable String logoPath, @Nullable String name, @Nullable String originCountry) {
        this.id = id;
        this.logoPath = logoPath;
        this.name = name;
        this.originCountry = originCountry;
    }

    public /* synthetic */ Network(Long l, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }

    @Nullable
    public final Long getId() {
        return this.id;
    }

    @Nullable
    public final String getLogoPath() {
        return this.logoPath;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getOriginCountry() {
        return this.originCountry;
    }
}
